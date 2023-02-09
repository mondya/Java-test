package utils;

import org.joda.time.DateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;


public class TimeUtils {
    //日期格式:yyyy-MM-dd
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //日期+时间格式：yyyy-MM-dd HH:mm:ss
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    //时间格式: HH:mm:ss
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * LocalDate转Date
     */
    static Date localDateToDate(LocalDate date){
        return Date.from(date.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
    }

    /**
     * LocalDateTime转Date
     */
    static Date localDateTimeToDate(LocalDateTime dateTime){
        return Date.from(dateTime.atZone(ZoneOffset.ofHours(8)).toInstant());
    }

    /**
     * Date转LocalDate
     */
    static LocalDate dateToLocalDate(Date date){
        return date.toInstant().atZone(ZoneOffset.ofHours(8)).toLocalDate();
    }

    /**
     * Date转LocalDateTime
     */
    static LocalDateTime dateToLocalDateTime(Date date){
        return date.toInstant().atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    /**
     * LocalDate转时间戳
     */
    static long localDateToTimeStamp(LocalDate localDate){
        return localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    /**
     * LocalDateTime转时间戳
     */
    static long localDateTimeToTimeStamp(LocalDateTime localDateTime){
        return localDateTime.atZone(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    /**
     * 时间戳转LocalDate
     */
    static LocalDate timeStampToLocalDate(Long timeStamp){
        return Instant.ofEpochMilli(timeStamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
    }

    /**
     * 时间戳转LocalDateTime
     */
    static LocalDateTime timeStampToLocalDateTime(Long timeStamp){
        return Instant.ofEpochMilli(timeStamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    /**
     * 把yyyy-MM-dd格式时间字符串转化为LocalDate
     * @param time "yyyy-MM-dd"
     * @return
     */
    static LocalDate getLocalDate(String time){
        return LocalDate.parse(time,DATE_FORMATTER);
    }
    
    static LocalDateTime getLocalDateTime(String time){
        return LocalDateTime.parse(time,DATE_TIME_FORMATTER);
    }

    /**
     * 获取两个相隔日期之间的年数(可以用来计算年龄)
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return
     */
    static long getYears(LocalDate startDate,LocalDate endDate){
        return startDate.until(endDate, ChronoUnit.YEARS);
    }

    /**
     * 获取两个相隔日期之间的月数
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return
     */
    static long getMonths(LocalDate startDate,LocalDate endDate){
        return startDate.until(endDate, ChronoUnit.MONTHS);
    }

    /**
     * 获取两个相隔日期之间的天数
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return
     */
    static long getDays(LocalDate startDate,LocalDate endDate){
        return startDate.until(endDate,ChronoUnit.DAYS);
    }
    /**
     * 获取yyyy-MM-dd格式字符串时间的时间戳
     * @param time 时间
     * @return long timeStamp
     */
    static long getDateStamp(String time){
       return getLocalDate(time).atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    /**
     * yyyy-MM-dd HH:mm:ss格式字符串转为时间戳
     * @param time 格式字符串
     * @return
     */
    static long getDateTimeStamp(String time){
        return getLocalDateTime(time).atZone(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    public static String getSectionDayStr(Long startDate, Long endDate){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String startLocalDate = Instant.ofEpochMilli(startDate).atOffset(ZoneOffset.ofHours(8)).toLocalDate().format(dateTimeFormatter);
        String endLocalDate = Instant.ofEpochMilli(endDate).atOffset(ZoneOffset.ofHours(8)).toLocalDate().format(dateTimeFormatter);
        return startLocalDate + "-" + endLocalDate;
    }
    
    public static void main(String[] args){
        //时间转化思路
        /**
         * date转localDate/localDateTime: 先转为瞬时实例Instant,在通过时区设置atZone/atOffset转化为ZoneDateTime/OffsetDateTime,这两个类都有toLocalDate,toLocalDateTime,toLocalTime方法
         * localDate/localDateTime转时间戳: localDate.atStartOfDay()/localDateTime.atZone,转化为ZoneDateTime/OffsetDateTime,然后转为Instant实例，调用toEpochMilli()方法获得时间戳
         * 时间戳转localDate/localDateTime: Instant.ofEpochMilli()获取Instant实例，通过atZone/atOffset转化为ZoneDateTime/OffsetDateTime
         * localDate/localDateTime转Date: 把localDate/localDateTime通过atStartOfDay(),atZone方法转为ZoneDateTime/OffsetDateTime，然后toInstant返回实例，使用Date.form()方法返回Date实例
         * 日期计算使用minus()和plus方法
         * 总结：转化为ZoneDateTime或者OffsetDateTime;
         * ZoneDateTime和OffsetDateTime之间可以通过toXXX方法互相转换，Instant通过atZone()或atOffset()转为ZoneDateTime和OffsetDateTime，
         * ZoneDateTime和OffsetDateTime也可以通过toInstant()方法获得Instant
         */
//        LocalDate now = LocalDate.now();
//        LocalDateTime nowTime = LocalDateTime.now();
//        System.out.println(new Date());
//        System.out.println(nowTime);

//        Long time = System.currentTimeMillis();
//        long dayOfWeek = new DateTime(time).minusDays(1).withTimeAtStartOfDay().getMillis();
//        System.out.println(dayOfWeek);
        System.out.println(getStartOfDay(new Date(1671120000000L)).getTime());
    }

    public static Date getStartOfDay(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    
}
