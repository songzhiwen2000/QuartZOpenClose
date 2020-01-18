package cn.qk.timerapi.util;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.QueryOperators;

import java.sql.Timestamp;

public class MongoQueryParams {
    public static final int SORT_POSITIVE = 1;        //正向排序
    public static final int SORT_NAGETIVE = -1;        //反向排序

    private DBObject queryParams = null;        //查询条件
    private DBObject sortParams = null;            //排序规则
    private DBObject fieldPrams = null;            //限制要查询的字段

    public MongoQueryParams() {
        queryParams = new BasicDBObject();
        fieldPrams = new BasicDBObject();
//		fieldPrams.put(MongoConstants.DATA_TIME_FIELD, 1);		//默认将时间字段加入
        sortParams = new BasicDBObject();
    }

    public MongoQueryParams(int deviceId, Timestamp startTime, Timestamp endTime, int sort) {
        queryParams = new BasicDBObject();
        fieldPrams = new BasicDBObject();
        sortParams = new BasicDBObject();
        this.addParam(MongoConstants.DEVICE_ID_FIELD, deviceId);
        this.addRange(MongoConstants.DATA_TIME_FIELD, endTime.getTime() / 1000, startTime.getTime() / 1000);
        this.addSortParams(MongoConstants.DATA_TIME_FIELD, sort);
    }

    public MongoQueryParams(Timestamp startTime, Timestamp endTime, int sort) {
        queryParams = new BasicDBObject();
        fieldPrams = new BasicDBObject();
        sortParams = new BasicDBObject();
        this.addRange(MongoConstants.DATA_TIME_FIELD, endTime.getTime() / 1000, startTime.getTime() / 1000);
        this.addSortParams(MongoConstants.DATA_TIME_FIELD, sort);
    }

    //等于
    public void addParam(String key, Object obj) {
        queryParams.put(key, obj);
    }

    //最大最小值
    public void addRange(String key, Object max, Object min) {
        if (null != max && null == min) {
            queryParams.put(key, new BasicDBObject(QueryOperators.LT, max));
        } else if (null == max && null != min) {
            queryParams.put(key, new BasicDBObject(QueryOperators.GTE, min));
        } else {
            queryParams.put(key, new BasicDBObject(QueryOperators.GTE, min).append(QueryOperators.LT, max));
        }
    }
    //最大最小值
    public void addEqRange(String key, Object max, Object min) {
        if (null != max && null == min) {
            queryParams.put(key, new BasicDBObject(QueryOperators.LTE, max));
        } else if (null == max && null != min) {
            queryParams.put(key, new BasicDBObject(QueryOperators.GTE, min));
        } else {
            queryParams.put(key, new BasicDBObject(QueryOperators.GTE, min).append(QueryOperators.LTE, max));
        }
    }

    //最大最小值
    public void addRangeNoEq(String key, Object max, Object min) {
        if (null == max && null == min) return;
        if (null != max && null == min) {
            queryParams.put(key, new BasicDBObject(QueryOperators.LT, max));
        } else if (null == max && null != min) {
            queryParams.put(key, new BasicDBObject(QueryOperators.GT, min));
        } else {
            queryParams.put(key, new BasicDBObject(QueryOperators.GT, min).append(QueryOperators.LT, max));
        }
    }

    //查询条件IN
    public void addIn(String key, Object[] arr, boolean isIn) {
        String relation = isIn ? QueryOperators.IN : QueryOperators.NIN;
        queryParams.put(key, new BasicDBObject(relation, arr));
    }

    /**
     * 处理故障预警的条件，即大于开始时间并且（小于结束时间或结束时间为空）
     *
     * @param startKey
     * @param startTime
     * @param endTime
     */
    public void addFaultRange(String startKey, long startTime, String endKey, long endTime) {
//		queryParams.put(startKey, new BasicDBObject(QueryOperators.GTE, startTime));
        BasicDBList orList = new BasicDBList();

        //开始时间在范围内
        BasicDBList andList1 = new BasicDBList();
        andList1.add(new BasicDBObject(startKey, new BasicDBObject(QueryOperators.GTE, startTime)));
        andList1.add(new BasicDBObject(startKey, new BasicDBObject(QueryOperators.LTE, endTime)));
        BasicDBObject andObj1 = new BasicDBObject();
        andObj1.put(QueryOperators.AND, andList1);
        orList.add(andObj1);

        //复位时间在范围内
        BasicDBList andList2 = new BasicDBList();
        andList2.add(new BasicDBObject(endKey, new BasicDBObject(QueryOperators.GTE, startTime)));
        andList2.add(new BasicDBObject(endKey, new BasicDBObject(QueryOperators.LTE, endTime)));
        BasicDBObject andObj2 = new BasicDBObject();
        andObj2.put(QueryOperators.AND, andList2);
        orList.add(andObj2);

        //开始时间前的故障，结束时间还未复位的
        BasicDBList andList3 = new BasicDBList();
        andList3.add(new BasicDBObject(startKey, new BasicDBObject(QueryOperators.LTE, startTime)));
        andList3.add(new BasicDBObject(endKey, null));
        BasicDBObject andObj3 = new BasicDBObject();
        andObj3.put(QueryOperators.AND, andList3);
        orList.add(andObj3);

        //开始时间前的故障，结束时间以后才复位的
        BasicDBList andList4 = new BasicDBList();
        andList4.add(new BasicDBObject(startKey, new BasicDBObject(QueryOperators.LTE, startTime)));
        andList4.add(new BasicDBObject(endKey, new BasicDBObject(QueryOperators.GTE, endTime)));
        BasicDBObject andObj4 = new BasicDBObject();
        andObj4.put(QueryOperators.AND, andList4);
        orList.add(andObj4);

        //四个条件用or连接
        queryParams.put(QueryOperators.OR, orList);
    }

    /**
     * 查询endTime内发送的故障预警
     * 适用于定时任务查询最近几分钟发送的故障
     *
     * @param endKey
     * @param interval
     * @param taskTime
     */
    public void addRecentFault(String endKey, long taskTime, int interval) {
        Timestamp endTime = new Timestamp(taskTime);
        Timestamp startTime = new Timestamp(taskTime - interval);
        BasicDBList orList = new BasicDBList();
        orList.add(new BasicDBObject(endKey, null));
        orList.add(new BasicDBObject(endKey, new BasicDBObject(QueryOperators.GTE, startTime.getTime() / 1000).append(QueryOperators.LTE, endTime.getTime() / 1000)));
        queryParams.put(QueryOperators.OR, orList);
    }

    /**
     * 处理故障预警和故障的条件，故障类型(faultType以;隔开 property_index+bit_index 为扩展性因该加 model_id)
     *
     * @param faultType
     */
    public void addSwitchFaultType(String faultType, long startTime, long endTime) {
        if (null != faultType && faultType.trim().length() > 0) {
            BasicDBList conditionList = new BasicDBList();
            BasicDBList orList = new BasicDBList();
            String[] faultArr = faultType.split(";");
            for (String fault : faultArr) {
                String[] bitArr = fault.split("_");
                if (bitArr.length != 2) {
                    continue;
                }
                BasicDBObject obj = new BasicDBObject();
                obj.put(MongoConstants.PROPERTY_INDEX_FIELD, Integer.valueOf(bitArr[0]));
                obj.put(MongoConstants.BIT_INDEX_FIELD, Integer.valueOf(bitArr[1]));
                orList.add(obj);
            }
            BasicDBObject orObj = new BasicDBObject();
            orObj.put(QueryOperators.OR, orList);
            conditionList.add(orObj);

            //时间条件
            BasicDBList timeOrList = new BasicDBList();
            timeOrList.add(new BasicDBObject(MongoConstants.END_TIME_FIELD, null));
            timeOrList.add(new BasicDBObject(MongoConstants.END_TIME_FIELD, new BasicDBObject(QueryOperators.GTE, startTime).append(QueryOperators.LTE, endTime)));
            BasicDBObject timeOrObj = new BasicDBObject();
            timeOrObj.put(QueryOperators.OR, timeOrList);
            conditionList.add(timeOrObj);
            queryParams.put(QueryOperators.AND, conditionList);
        }

    }

    //model_id + property_index + value
    public void addValueFaultType(String faultType) {
        if (null != faultType && faultType.trim().length() > 0) {

            BasicDBList orList = new BasicDBList();
            String[] faultArr = faultType.split(";");
            for (String fault : faultArr) {
                String[] bitArr = fault.split("_");
                if (bitArr.length != 3) {

                    continue;
                }
                BasicDBObject obj = new BasicDBObject();
                obj.put(MongoConstants.MODEL_TYPE_FIELD, Integer.valueOf(bitArr[0]));
                obj.put(MongoConstants.PROPERTY_INDEX_FIELD, Integer.valueOf(bitArr[1]));
                //obj.put(GlobalConstants.BIT_INDEX_FIELD, Integer.valueOf(bitArr[2]));  //表里的bit_index放value 同一种设备设定只有一种取值方式switch或者 value
                obj.put(MongoConstants.WARN_VALUE_FIELD, Integer.valueOf(bitArr[2]));
                orList.add(obj);
            }
            queryParams.put(QueryOperators.OR, orList);

        }


    }

    //删除某个查询条件
    public void deleteKey(String key) {
        queryParams.removeField(key);
    }

    //添加排序规则
    public void addSortParams(String key, int sort) {
        sortParams.put(key, sort);
    }

    //选择要查询的字段
    public void addQueryField(String key) {
        fieldPrams.put(key, 1);
    }

    //选择要查询的字段
    public void addQueryField(String[] keys) {
        for (String key : keys)
            fieldPrams.put(key, 1);
    }

    public void addQueryFields(String[] arr) {
        for (String str : arr) {
            fieldPrams.put(str, 1);
        }
    }

    public DBObject getMongoParams() {
        return queryParams;
    }

    public DBObject getSortParams() {
        return sortParams;
    }

    public DBObject getFieldPrams() {
        return fieldPrams;
    }
}

