package xhh;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author xhh
 * @date 2021/12/20 10:18
 */
public class TestTime {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        System.out.println(now.getTime());

        LocalDate today = LocalDate.now();
        System.out.println("month = "+today.getMonthValue());
        LocalDate minus = today.minus(1,ChronoUnit.DAYS);
        LocalDate localDate = today.minusDays(1);
        if (minus.equals(localDate)){
            System.out.println("true=========true");
        }
        System.out.println(today);
        //获取时间戳
        System.out.println(today.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());

        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);
        Long now2 = now1.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println("now2:"+now2);

        //时间戳转换成LocalDateTime
        LocalDateTime date = Instant.ofEpochMilli(now2).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("today:"+dateTimeFormatter.format(today.atStartOfDay()));
        System.out.println(dateTimeFormatter.format(date));

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime localTime = LocalDateTime.now();
        System.out.println("lcoalTime = "+ localTime);
        System.out.println(dateTimeFormatter1.format(localTime));
        LocalTime time = LocalTime.parse("19:23", DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println("time="+time);

        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        System.out.println(format.format(date1));
        Time hour = new Time(date1.getTime());
        System.out.println("hour"+hour);

        LocalDate birthDay = LocalDate.parse("1999-02-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Period period = Period.between(birthDay,today);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(today.toEpochDay() - birthDay.toEpochDay());

        long year = birthDay.until(today, ChronoUnit.YEARS);
        long days = birthDay.until(today, ChronoUnit.DAYS);
        System.out.println(year);
        System.out.println(days);
        //获取30天前的
        System.out.println("30天前"+today.minusDays(30));
        LocalTime timeNow = LocalTime.now();
        System.out.println("timeNow = " + timeNow.format(DateTimeFormatter.ofPattern("HH:mm")));

        System.out.println("instant = " + today.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
        System.out.println(testMul());
    }
    
    //测试乘法
    static BigDecimal testMul(){
        return new BigDecimal(2 * 5);
    }
    
}
