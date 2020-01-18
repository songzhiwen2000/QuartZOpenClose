package cn.qk.timerapi.util;

import com.mongodb.*;
import com.mongodb.util.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.util.*;

@Component
public class MongoQueryTool {
    private static MongoQueryTool instance;
    private Mongo mongo;
    private DB db;

    private String mongoServerIp;
    private int mongoPort;
    private String mongoDBName;


    public static MongoQueryTool getInstance() {
        if (null == instance) {
            init();
        }
        return instance;
    }

    private static void init() {
        instance = new MongoQueryTool();
    }

    private MongoQueryTool() {
        loadConf();
        try {
            mongo = new Mongo(mongoServerIp, mongoPort);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        db = mongo.getDB(mongoDBName);
    }

    private void loadConf() {

        mongoServerIp = "172.20.12.241";
        mongoPort = 27017;
        mongoDBName = "haierv3";
    }

    public void insertData(String tableName, JSONObject object) {
        DBCollection collection = db.getCollection(tableName);
        BasicDBObject dbObject = (BasicDBObject) JSON.parse(object.toString());
        collection.insert(dbObject);
    }

    /**
     * MongoDB查询，获得Mongodb索引
     *
     * @param tableName 表名
     * @param params
     * @param dataGrid
     * @param docNum    要获取的记录总数,不需限制给-1
     * @return
     */
    public DBCursor getDbCursor(String tableName, MongoQueryParams params, DataGrid dataGrid, int docNum) {
//		System.out.println(params.getMongoParams().toString());
        DBCollection col = db.getCollection(tableName);
        DBCursor cursor = null;
        if (null == params) {
            params = new MongoQueryParams();
        }
        if (null == dataGrid) {
            cursor = col.find(params.getMongoParams(), params.getFieldPrams());
        } else {
            //分页查询
            cursor = setPageInfo(col, params, dataGrid);
        }
        if (null != params.getSortParams()) {
            cursor = cursor.sort(params.getSortParams());
        }
        if (docNum != -1) cursor = cursor.limit(docNum);
        return cursor;
    }

    /**
     * MongoDB查询，利用映射直接获取实体
     *
     * @param tableName 表名
     * @param params
     * @param dataGrid
     * @param docNum    要获取的记录总数,不需限制给-1
     * @return
     */
    public List<Object> queryMongo(String tableName, MongoQueryParams params, DataGrid dataGrid, int docNum, String className) {
        DBCursor cursor = this.getDbCursor(tableName, params, dataGrid, docNum);
        return parseObj(cursor, className);
    }

    /**
     * Mongodb查询，查询结果不映射实体，直接放到json中
     *
     * @param tableName
     * @param params
     * @param dataGrid
     * @param docNum
     * @return
     */
    public JSONArray queryMongoJson(String tableName, MongoQueryParams params, DataGrid dataGrid, int docNum) {
        DBCursor cursor = this.getDbCursor(tableName, params, dataGrid, docNum);
        return parseJson(cursor, 0);
    }

    /**
     * Mongodb查询，查询结果不映射实体，直接放到json中
     *
     * @param tableName
     * @param params
     * @param dataGrid
     * @param docNum
     * @return
     */
    public List<DBObject> queryMongoObj(String tableName, MongoQueryParams params, DataGrid dataGrid, int docNum) {
        DBCursor cursor = this.getDbCursor(tableName, params, dataGrid, docNum);
        List<DBObject> list = new ArrayList<DBObject>();
        while (cursor.hasNext()) {
            list.add(cursor.next());
        }
        return list;
    }

    public List<DBObject> queryMongoObj(String tableName, MongoQueryParams params, int docNum) {
        DBCursor cursor = this.getDbCursor(tableName, params, null, docNum);
        List<DBObject> list = new ArrayList<DBObject>();
        while (cursor.hasNext()) {
            list.add(cursor.next());
        }
        return list;
    }

    /**
     * @param tableName 表名
     * @param params    查询条件
     * @param dataGrid
     * @param docNum    查询总记录数 不需限制给-1
     * @param interval  时间间隔，单位是秒
     * @return
     */
    public DBCursor getFrequenceCursor(String tableName, MongoQueryParams params, DataGrid dataGrid, int docNum, int interval) {
        //先查选一条记录，获取起始点，再利用起始点根据时间间隔取数据
        return getDbCursor(tableName, params, dataGrid, docNum);
    }

    public List<Object> getFrenquenceObj(String tableName, MongoQueryParams params, DataGrid dataGrid, int docNum, int interval, String className) {
        DBCursor cursor = this.getFrequenceCursor(tableName, params, dataGrid, docNum, interval);
        return parseObj(cursor, className);
    }

    public JSONArray getFrequenceJson(String tableName, MongoQueryParams params, DataGrid dataGrid, int docNum, int interval) {
        DBCursor cursor = this.getFrequenceCursor(tableName, params, dataGrid, docNum, interval);
        return parseJson(cursor, interval);
    }

    //设置分页
    private DBCursor setPageInfo(DBCollection col, MongoQueryParams params, DataGrid dataGrid) {
        int rowOfPage = dataGrid.getRows();
        int curPageNum = dataGrid.getPage();
        if (curPageNum > 0) curPageNum -= 1;
        DBCursor cursor = col.find(params.getMongoParams(), params.getFieldPrams());
        int allRows = cursor.count();

        cursor = cursor.skip(curPageNum * rowOfPage);
        cursor = cursor.limit(rowOfPage);
        int allPageNum = 0;
        if (allRows % rowOfPage == 0) {
            allPageNum = allRows / rowOfPage;
        } else {
            allPageNum = allRows / rowOfPage + 1;
        }
        dataGrid.setTotal(allRows);
        return cursor;
    }

    private List<Object> parseObj(DBCursor cursor, String className) {
        List<Object> list = new ArrayList<Object>();
        MongoObjReflect<Object> reflect = new MongoObjReflect<Object>();
        while (cursor.hasNext()) {
            DBObject dbObj = cursor.next();
            try {
                Object obj = reflect.parseObject(dbObj, className);
                list.add(obj);
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private JSONArray parseJson(DBCursor cursor, int frequency) {
        JSONArray arr = new JSONArray();
        Map<String, Long> map = new HashMap<String, Long>();
        while (cursor.hasNext()) {
            DBObject dbObj = cursor.next();
            Set<String> set = dbObj.keySet();
            Iterator<String> it = set.iterator();
            JSONObject jsonObj = new JSONObject();
            while (it.hasNext()) {
                String key = it.next();
                //排除Mongodb默认的id
                if (!key.equalsIgnoreCase("_id")) {
                    Object value = dbObj.get(key);
                    if (value.getClass() == Double.class) {
                        Double d = (Double) value;
                        if (d.isInfinite() || d.isNaN()) continue;
                    }
                    jsonObj.put(key, dbObj.get(key));
                }
            }
            if (frequency == 0) {
                arr.add(jsonObj);        //不需要考虑频率
            } else {
                if (jsonObj.containsKey(MongoConstants.DATA_TIME_FIELD)) {
                    long dataTime = jsonObj.getLong(MongoConstants.DATA_TIME_FIELD);
                    String key = "key";
                    if (!map.containsKey(key)) {
                        arr.add(jsonObj);
                        map.put(key, dataTime);
                    } else {
                        if (Math.abs(dataTime - map.get(key)) >= frequency) {
                            arr.add(jsonObj);
                            map.put(key, dataTime);
                        }
                    }
                }
            }
        }
        return arr;
    }


}
