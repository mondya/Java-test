package test

import org.joda.time.DateTime

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.stream.Collectors


class TestList {
    static void main(String[] args) {
        List<String> list = []
        list.add("2")
        list.add("2")
        list.add("2")
        list.remove("2")
        println "list:"+list
        
        Integer count = 2 * 4
        println "count = "+ count

        String teacher = ""
        println teacher.split(",").toList()
        println "ss"+list.stream().map(s -> s).collect(Collectors.toList())
        
        println LocalDate.now().atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli()
        println LocalDateTime.now().atZone(ZoneOffset.ofHours(8)).toInstant().toEpochMilli()

        Date  date = new Date()
        //当天0秒时间戳
        println (new DateTime(date).millis)

        println (new DateTime().withMillisOfDay(0).millis)
    }
}
