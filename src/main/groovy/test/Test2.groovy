package test

import com.alibaba.fastjson.JSONArray
import com.google.gson.JsonObject
import org.apache.commons.lang3.StringUtils
import org.joda.time.DateTime

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class Test2 {
    
    private static final TIME_DAY_MILLISECOND = 86400000
    
    static void main(String[] args) {
       String IMG_PATTERN = "([a-zA-z]+://[^\\s]*.com/)|(\\?Expires=[^\\s]*)"

        def k = "https://product360.oss-cn-hangzhou.aliyuncs.com/5_10%E4%BC%98%E5%8C%96%E6%96%B9%E6%A1%88.png?Expires=1660298978&OSSAccessKeyId=TMP.3KigbNjiok42eBHBqhay5dGQV4mBCZ7BoAKkpPd22YnuartM7VqwgvCPyqtuxf34ewVpTDa2ZG8bmdSVv85QHxnYatFjXY&Signature=SHLtCtpE8B9srIJzasi9694tu%2BI%3D"

        def s = k.replaceAll(IMG_PATTERN, "")
        println s
    }
    
    static String test(String s){
        
    }

    static List<Long> get7DayTimeStamp(Long startDate, Long endDate){
        LocalDate data = Instant.ofEpochMilli(endDate).atZone(ZoneOffset.ofHours(8)).toLocalDate().plus(1, ChronoUnit.DAYS)
        endDate =  data.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli()
        List<Long> dayTimeStampList = []
        int size = ((endDate - startDate) / TIME_DAY_MILLISECOND) as int
        println size
        for (int i = 0; i<= (size-1); i++){
            endDate = endDate - TIME_DAY_MILLISECOND
            dayTimeStampList << (endDate)
        }
        return dayTimeStampList
    }
    
    static List<Long> getTime(Long startDate, Long endDate){
        List<Long> list = []
        int size = ((endDate - startDate) / TIME_DAY_MILLISECOND) as int
        println(size)
        for (int i = 0; i<= size; i++){
            list << endDate
            endDate = endDate - TIME_DAY_MILLISECOND
        }
        return list
    }
    
    static String getTimeStr(Long dateTime){
        LocalDate date = Instant.ofEpochMilli(dateTime).atZone(ZoneOffset.ofHours(8)).toLocalDate()
        return date.format(DateTimeFormatter.ofPattern("M.dd"))
    }

    static List<Long> getDayTimeStampSection(Long startDate, Long endDate){
        startDate = new DateTime(startDate).withMillisOfDay(0).millis
        endDate = new DateTime(endDate).withMillisOfDay(0).millis
        List<Long> dayTimeStampList = []
        int size = ((endDate - startDate) / TIME_DAY_MILLISECOND) as int
        for (int i = 0; i<= size; i++){
            dayTimeStampList << endDate
            endDate = endDate - TIME_DAY_MILLISECOND
        }
        dayTimeStampList.sort{
            it
        }
        return dayTimeStampList
    }
}
