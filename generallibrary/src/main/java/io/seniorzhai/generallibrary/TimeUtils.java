package io.seniorzhai.generallibrary;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by zhaitao on 15/5/27.
 */
public class TimeUtils {
    public static final long SECOND = 1000;
    public static final long MINUTE = 60 * SECOND;
    public static final long HOUR = 60 * MINUTE;
    public static final long DAY = 24 * HOUR;
    public static final long WEEK = DAY * 7;
    public static final long MONTH = DAY * 30;
    public static final long HALF_MONTH = MONTH / 2;
    public static final String DATE_FORMATE_ALL = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMATE_YEAR_MOUTH = "yyyyMM";
    public static final String DATE_FORMATE__YEAR_MOUTH_DAY_HOUR_MINUTE = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMATE_MOUTH_DAY_HOUR_MINUTE = "MM/dd HH:mm";
    public static final String DATE_FORMATE_YEAR_MOUTH_DAY = "yyyy-MM-dd";
    public static final String DATE_FORMATE_TRANSACTION = "dd/MM/yyyy HH:mm";
    public static final String DATE_FORMATE_DAY_HOUR_MINUTE = "MM/dd HH:mm";
    public static final String DATE_FORMATE_HOUR_MINUTE = "HH:mm";
    public static final String DATE_FORMATE_HOUR_MINUTE_SECOND = "HH:mm:ss";
    public static final String DATE_FORMATE_MOUTH_DAY_CHINAE = "MM月dd日";
    public static final String DATE_FORMATE_HOUR_MINUTE_YEAR_MOUTH_DAY = "HH:mm yyyy-MM-dd";
    public static final String BEIJING_TIMEZONE = "GMT+8:00";
    public static final String DATE_DEFAULT_FORMATE = DATE_FORMATE_YEAR_MOUTH_DAY;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat();

    public static Calendar newCalendar() {
        return Calendar.getInstance(TimeZone.getTimeZone(BEIJING_TIMEZONE));
    }

    public static long timeSince1970() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(BEIJING_TIMEZONE));
        return calendar.getTimeInMillis();
    }

    public static long daySince1970() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(BEIJING_TIMEZONE));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public static long getTime(String s) {
        return getTime(s, DATE_DEFAULT_FORMATE);
    }

    public static long getTime(String s, String pattern) {
        if (TextUtils.isEmpty(pattern)) {
            pattern = DATE_DEFAULT_FORMATE;
        }
        dateFormat.applyPattern(pattern);
        dateFormat.setTimeZone(TimeZone.getTimeZone(BEIJING_TIMEZONE));
        Date date = new Date();
        try {
            date = dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    public static int daysBetween(long fromTime, long toTime) {
        return (int) ((toTime - fromTime) / DAY);
    }

    public static int[] WEEK_NAME = new int[]{R.string.date_sunday, R.string.date_monday, R.string.date_tuesday,
            R.string.date_wednesday, R.string.date_thursday, R.string.date_friday, R.string.date_saturday,};

    public static int getWeekTimeResId(long time) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(BEIJING_TIMEZONE));
        calendar.setTimeInMillis(time);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0) {
            dayOfWeek = 0;
        }
        return WEEK_NAME[dayOfWeek];
    }

    public static String format(long milliseconds) {
        return format(milliseconds, DATE_DEFAULT_FORMATE);
    }

    public static String format(long milliseconds, String pattern) {
        if (TextUtils.isEmpty(pattern)) {
            pattern = DATE_DEFAULT_FORMATE;
        }
        dateFormat.applyPattern(pattern);
        dateFormat.setTimeZone(TimeZone.getTimeZone(BEIJING_TIMEZONE));
        Date d = new Date();
        d.setTime(milliseconds);
        return dateFormat.format(d);
    }

    public static final long TS_MAX = 253402271999000L;// 最大有限期

    public static String formatForShow(long milliseconds, String pattern) {
        if (milliseconds >= TS_MAX) {
            return "永久有效";
        }
        if (TextUtils.isEmpty(pattern)) {
            pattern = DATE_DEFAULT_FORMATE;
        }
        dateFormat.applyPattern(pattern);
        dateFormat.setTimeZone(TimeZone.getTimeZone(BEIJING_TIMEZONE));
        Date d = new Date();
        d.setTime(milliseconds - 1);
        return dateFormat.format(d);
    }

    public static String addMonth(String date, String pattern, int add) {
        Date dd = null;
        dateFormat.applyPattern(pattern);
        try {
            dd = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar temp = Calendar.getInstance();
        temp.setTime(dd);
        temp.add(Calendar.MONTH, add);
        return dateFormat.format(temp.getTimeInMillis());
    }
}
