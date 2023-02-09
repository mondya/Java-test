package test

class TestGetMethod {

    static void main(String[] args) {
        List<WeekVO> weekVOList = []
        WeekVO weekVO = new WeekVO(weekId: 1, dayStamp: 12L, top: true)
        weekVOList.add(weekVO)
        
        WeekVO weekVO1 = new WeekVO(weekId: 1, dayStamp: 12L, top: true) 
        weekVOList.add(weekVO1)

        WeekVO weekVO2 = new WeekVO(weekId: 1, dayStamp: 13L, top: true)
        weekVOList.add(weekVO2)

        WeekVO weekVO3 = new WeekVO(weekId: 1, dayStamp: 13L, top: true)

        
        weekVOList.removeAll([weekVO3])
        
        println weekVOList
    }
}
