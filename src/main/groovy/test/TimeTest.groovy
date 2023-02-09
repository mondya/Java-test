package test

import org.joda.time.DateTime

import java.sql.Time
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class TimeTest {
    static Date getDateForTime(Time time){
        Calendar calendar = Calendar.getInstance()
//        calendar.set(Calendar.YEAR, new Date().getYear())
//        println new Date().getYear()
//        calendar.set(Calendar.MONTH, new Date().getMonth())
//        println new Date().getMonth()
//        calendar.set(Calendar.DAY_OF_MONTH, new Date().getDay())
//        println new Date().getDay()
        calendar.setTime(new Date())
        calendar.set(Calendar.HOUR_OF_DAY, time.hours)
        println time.hours
        calendar.set(Calendar.MINUTE, time.minutes)
        println time.minutes
        calendar.set(Calendar.SECOND, time.seconds)
        println time.seconds
        return calendar.getTime()
    }

    static long getTime(Long start,Long end){
        LocalDate startDate = Instant.ofEpochMilli(start).atZone(ZoneOffset.ofHours(8)).toLocalDate()
        LocalDate endDate = Instant.ofEpochMilli(end).atZone(ZoneOffset.ofHours(8)).toLocalDate()
        return startDate.until(endDate, ChronoUnit.DAYS)
    }
//    static void main(String[] args) {
//        Map<String,String> map = [:]
//        LocalDate startDate = Instant.ofEpochMilli(1652162851739L).atZone(ZoneOffset.ofHours(8)).toLocalDate()
//        LocalDate endDate = Instant.ofEpochMilli(1652162851739L).atZone(ZoneOffset.ofHours(8)).toLocalDate()
//        String startStr = startDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
//        String endStr = endDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
//        long day =  getTime(1652162851739L,1652162851739L)
//        Integer i = (7 % 7)
//        Integer j = (7 / 7).intValue()
//        println i + "," + j
//        if (day == 0){
//            map.put(startStr,startStr)
//        } else if (i == 0 && j==0){
//            map.put(startStr,endStr)
//        }
//    }

    static void main(String[] args) {
        List<BigDecimal> scoreList = []
        scoreList.removeAll([null])
        BigDecimal
    }

    static String getFixLenthString(int strLength) {

        Random rm = new Random()

        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength)

        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross)

        // 返回固定的长度的随机数
        return fixLenthString.substring(1, strLength + 1)
    }
}
