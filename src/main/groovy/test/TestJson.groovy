package test

import com.alibaba.fastjson.JSONObject


class TestJson {
    static void main(String[] args) {
//        WeekVO weekVO = JSONObject.parseObject("{\"weekId\":1,\"dayStamp\":123344,\"top\":false}", WeekVO.class)
//        List<WeekVO> weekVOS = JSONObject.parseArray("[{\"weekId\":1,\"dayStamp\":123344,\"top\":false}]",WeekVO.class)
//        println weekVO
//        println weekVOS

//        Date date = new Date(new java.util.Date().time)
//        Time time = new Time(new java.util.Date().getTime());
//        println date
//        println time
        Map map = [p: null]
        test(map.p as Integer)
        
    }
    
    static void test(int name) {
        println "hello"
    }
}
