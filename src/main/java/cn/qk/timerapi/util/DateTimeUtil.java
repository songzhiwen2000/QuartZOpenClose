package cn.qk.timerapi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Long changeDateToLong(String date) {
        Date d;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
        return d.getTime() / 1000;
    }

    public static String changeLongToDateString(Object date) {
        long time = Long.parseLong(date.toString()) * 1000;
        return sdf.format(new Date(time));
    }

}
