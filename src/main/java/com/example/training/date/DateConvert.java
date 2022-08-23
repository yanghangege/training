package com.example.training.date;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author yang han
 * @date 2022/8/20 14:39
 */
@Slf4j
public class DateConvert {


    public static void main(String[] args) {
        String date = "2022-08-20 14:42:00";
        long l = timeMillisOf(date);
        log.info("时间戳输出：{}", l);
    }

    /**
     * 获取指定时间的时间戳(毫秒)  格式：yyyy-MM-dd HH:mm:ss
     *
     * @param time 时间
     * @return 时间戳(毫秒)
     */
    public static long timeMillisOf(String time) {
        return timeMillisOf(time, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取指定时间及格式的时间戳(毫秒)
     *
     * @param time    时间
     * @param pattern 格式
     * @return 时间戳(毫秒)
     */
    public static long timeMillisOf(String time, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date != null ? date.getTime() : 0;
    }

    /**
     * 获取指定时间的时间戳(毫秒)字符串  格式：yyyy-MM-dd HH:mm:ss
     *
     * @param time 时间
     * @return 时间戳(毫秒)字符串
     */
    public static String timeMillisStrOf(String time) {
        return timeMillisStrOf(time, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取指定时间及格式的时间戳(毫秒)字符串
     *
     * @param time    时间
     * @param pattern 格式
     * @return 时间戳(毫秒)字符串
     */
    public static String timeMillisStrOf(String time, String pattern) {
        return String.valueOf(timeMillisOf(time, pattern));
    }


    /**
     * 通过时间获取date对象 格式：yyyy-MM-dd HH:mm:ss
     *
     * @param time 时间
     * @return date
     */
    public static Date dateOf(String time) {
        return dateOf(time, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 通过时间获取date对象
     *
     * @param time    时间
     * @param pattern 格式
     * @return date
     */
    public static Date dateOf(String time, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 通过时间戳获取date对象
     *
     * @param timeMillis 时间戳
     * @return date
     */
    public static Date dateOf(long timeMillis) {
        return new Date(timeMillis);
    }

    /**
     * 获取当前时间戳(毫秒)
     *
     * @return 时间戳(毫秒)
     */
    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前时间戳(毫秒)字符串
     *
     * @return 时间戳(毫秒)字符串
     */
    public static String currentTimeMillisStr() {
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * 通过时间戳获取时间 格式：yyyy-MM-dd HH:mm:ss
     *
     * @param timeMillis 时间戳(毫秒)
     * @return 时间
     */
    public static String timeOf(long timeMillis) {
        return timeOf(timeMillis, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 通过时间戳获取时间 格式：yyyy-MM-dd HH:mm:ss
     *
     * @param timeMillis 时间戳(毫秒)
     * @param pattern    格式
     * @return 对应时间
     */
    public static String timeOf(long timeMillis, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(timeMillis);
    }

    /**
     * 通过date获取时间 格式：yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期
     * @return 时间
     */
    public static String timeOf(Date date) {
        return timeOf(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 通过date获取时间
     *
     * @param date    日期
     * @param pattern 格式
     * @return 时间
     */
    public static String timeOf(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 获取当前时间 格式：yyyy-MM-dd HH:mm:ss
     *
     * @return 时间
     */
    public static String currentTime() {
        return currentTime("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当前时间
     *
     * @param pattern 格式
     * @return 时间
     */
    public static String currentTime(String pattern) {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return ldt.format(dtf);
    }
}
