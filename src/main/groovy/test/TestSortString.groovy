package test

class TestSortString {
    static void main(String[] args) {
        List<WeekVO> list = []
        List<WeekVO> vos = []
        WeekVO weekVO = new WeekVO(weekId: 1, dayStamp: 2l, week: "1")
        WeekVO weekVO1 = new WeekVO(weekId: null, dayStamp: 2l, week:  "0")
        WeekVO weekVO2 = new WeekVO(weekId: 999, dayStamp: 4l)
        WeekVO weekVO3 = new WeekVO(weekId: 999, dayStamp: 3l)
        list.add(weekVO1)
        list.add(weekVO)
        list.add(weekVO2)
        list.add(weekVO3)
        
        list.groupBy {it.weekId}
        
        println list.groupBy {it.weekId}
    }
}
