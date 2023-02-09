package test

import org.apache.commons.lang3.StringUtils
import org.apache.tools.ant.types.resources.Sort
import org.joda.time.DateTime

import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

/**
 * @author xhh* @date 2022/3/10 15:14
 */
class Test {
    static void main(String[] args) {
        LocalDate now = LocalDate.now()
        LocalDate startDate = LocalDate.parse("2019-10-25",DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        int days = startDate.until(now, ChronoUnit.DAYS).intValue()
        List<WeekVO> weekVOS = []
        for (i in 1..<days+1) {
            LocalDate localDate = startDate.minusDays(-i)
            WeekVO weekVO = new WeekVO()
            weekVO.weekId = startDate.until(localDate,ChronoUnit.WEEKS) + 1
            weekVO.dayStamp = localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli()
            weekVOS << weekVO
        }
        weekVOS.each {println it.toString()}
        List<SortTest> sortTestList = new ArrayList<>();
        sortTestList.add(new SortTest(3,1,true,"张三"))
        sortTestList.add(new SortTest(5,2,true,"小五"))
        sortTestList.add(new SortTest(1,2,false,"李四"))
        sortTestList.add(new SortTest(4,1,false,"666"))
        sortTestList.add(new SortTest(7,5,true,"hello"))
        sortTestList.add(new SortTest(1,0,true,"t"))
        sortTestList.add(new SortTest(3,0,true,"q"))
        sortTestList.sort{
            [it.id , it.idx]
        }
        
        println("sortTestList:"+sortTestList)
        Map<Boolean,List<SortTest>> map = sortTestList.groupBy {it.top}
        List<SortTest> topSortTest = map.get(Boolean.TRUE).sort{-it.idx}
        List<SortTest> noTpoSort = map.get(Boolean.FALSE).sort{-it.idx}
        List<SortTest> newSort = []
        topSortTest.each {
            newSort << it
        }    
        
        noTpoSort.each {
            newSort << it
        }
//        println newSort
        
        String build = "" + "" + ""
        println StringUtils.isNotEmpty(build)
        
        String b2 = "-he/ll/22-"
        println b2.replaceAll("(^-)|(-\$)","")

        println "b2:$b2"
        println new DateTime().withMillisOfDay(0).millis
        
        List<String> list1 = ['22','33','44','44']
        List<String> list2 = ['33', '44']
        List<String> nonList = []
//        List<String> list3 = list1.stream().filter(notCommet -> list2.stream().map(s ->s ).collect(Collectors.toList()))
        println(nonList.removeAll(list2))
        list1.each {println(it)}
        Map<String,String> stringMap = [:]
        stringMap.put("id","hello")
        stringMap.put("id","yo")
        println stringMap
    }
    
}
