package cn.qk.timerapi.util;

import com.mongodb.DBObject;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Set;

public class MongoObjReflect<T> {
    private static final String MONGO_ID = "_id";

    public T parseObject(DBObject mongoObj , String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        @SuppressWarnings("unchecked")
        T t = (T) Class.forName(className).newInstance();

        Set<String> mongoSet = mongoObj.keySet();
        for(String str : mongoSet){
            if(str.equals(MONGO_ID)) continue;

            String fieldName = parseFieldName(str);
            try {
                Field field = t.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);

                //特殊处理时间
                if(fieldName.equals("DT") || fieldName.equals("startTime") || fieldName.equals("endTime")){
                    Timestamp time = new Timestamp((Long) mongoObj.get(str)*1000);
                    field.set(t, time);
                }else{
                    field.set(t, mongoObj.get(str));
                }
            } catch (SecurityException | IllegalArgumentException | NoSuchFieldException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return t;
    }

    //按照驼峰原则生成变量名
    private String parseFieldName(String fieldName){
        String[] arr = fieldName.split("_");
        StringBuffer buf = new StringBuffer();
        for(int i = 0 ; i < arr.length ; ++i){
            if(null == arr[i] || arr[i].trim().length() == 0) continue;
            if(i == 0){
                buf.append(arr[i]);
            }else{
                buf.append(arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1, arr[i].length()));
            }
        }
        return buf.toString();
    }

}