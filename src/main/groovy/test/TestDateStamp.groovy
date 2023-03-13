package test

import org.joda.time.DateTime

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class TestDateStamp {
    static void main(String[] args) {
        String date = "2023-02-02 17:00:13"
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        println LocalDateTime.parse(date, dateTimeFormatter)
        List<Long> stampList = []
        for (i in 0..<37) {
            stampList << LocalDateTime.parse(date, dateTimeFormatter).plusDays(i).toInstant(ZoneOffset.ofHours(8)).toEpochMilli()
        }
        
        println stampList
    }
}
