package com.zyqhw.springboot.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * create
 * by
 * ljp
 * 2018.06.12
 *
 */
public class GetDayUtils {
    //public static final SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    //获得当天日期 精确到天
    public static String getNowday() {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH);//获取月份
        int day = ca.get(Calendar.DATE);//获取日
        String now = year + "-" + (month + 1) + "-" + day;
        return now;
    }

    //获得当天的凌晨时间截  毫秒级
    public static long getDayStarUnix() {

        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.MILLISECOND, 0);
        return cal2.getTimeInMillis();
    }
    //获得当天的24点 结束时间截 毫秒级
    public static long getDayEndUnix() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
    /**
     * 得到本周周一
     *
     * @return yyyy-MM-dd
     */
    public static String getMondayOfThisWeek() {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 1);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        return fmt.format(c.getTime());
    }

    /**
     * 得到本周周日
     *
     * @return yyyy-MM-dd
     */
    public static String getSundayOfThisWeek() {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 7);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        return fmt.format(c.getTime());
    }

    public static void main(String[] args){
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH);//获取月份
        int day = ca.get(Calendar.DATE);//获取日
        System.out.println("year:"+year);
        System.out.println("month:"+month);
        System.out.println("day:"+day);
        System.out.println("key:" + year + "-"+ (month + 1) + "-" + day);
        System.out.println(getDayStarUnix());
        System.out.println(new Date(getDayStarUnix()));
        System.out.println(getMondayOfThisWeek()+" 00:00:00");
        System.out.println(getSundayOfThisWeek()+" 23:59:59");

    }

}
