package test

import java.time.LocalDate

class TestMap {
    static void main(String[] args) {
//        List<WeekVO> weekVOS = [new WeekVO(weekId: 100L,dayStamp: 123L), new WeekVO(weekId: 100L,dayStamp: 234L),new WeekVO(weekId: 200L,dayStamp: 213L)]
//        Map<Long,List<WeekVO>> map = [:]
//        weekVOS.each {vo ->
//            if (map.get(vo.weekId)){
//                map.get(vo.weekId).add(vo)
//            }else{
//                map[vo.weekId] = [vo]
//            }
//        }
//        println map
//        
//        map = weekVOS.groupBy {it.weekId}
//        println "groupby:$map"
//
//        List<WeekVO> newWeekVOS = []
//        println newWeekVOS.sort{it.weekId} 
//        
//        println map.get(100L) ? map.get(100L).size() : 0
//        
//        List<WeekVO> weekList = []
//        weekList = weekVOS
//        println weekList
        
        Map map = [:]
        map.put("s",1)
        map.put("s", 2)
        println map
    }
    
}
