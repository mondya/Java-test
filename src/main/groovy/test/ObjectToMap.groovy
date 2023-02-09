package test

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import org.joda.time.DateTime
class ObjectToMap {
    static resultVOObject2Map(Object obj) {
        if (obj) {
            def map = obj.properties
            map.remove('class')
            return map
        } else {
            return null
        }
    }

    static void main(String[] args) {
        println resultVOObject2Map(new WeekVO(weekId: 2, dayStamp: 122))
    }
    
    static Integer getDayIndexOfWeek(Long timeStamp){
        LocalDate localDate = Instant.ofEpochMilli(timeStamp).atZone(ZoneOffset.ofHours(8)).toLocalDate()
        localDate.getDayOfWeek().value
    }

    static long getDateMillisOfDay(Date date) {
        DateTime dateTime = new DateTime(date)
        new DateTime(dateTime.year, dateTime.monthOfYear, dateTime.dayOfMonth, 0, 0).millis
    }
    
}
