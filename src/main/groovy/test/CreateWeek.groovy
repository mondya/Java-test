package test

import org.joda.time.DateTime


class CreateWeek {
    static void main(String[] args) {
        Date startDate = new Date(2023,2,1);
        Date endDate = new Date(2023,7,31);
        List<NatureWeekVO> natureWeekVOList = []
        while (startDate.before(endDate) || startDate.time == endDate.time) {
            DateTime dateTime = new DateTime(startDate)
            NatureWeekVO vo = new NatureWeekVO()
            vo.dayOfWeek = dateTime.dayOfWeek
            vo.weekOfYear = dateTime.weekOfWeekyear
            natureWeekVOList.add(vo)
            startDate = dateTime.plusDays(1).toDate()
        }
        
        println natureWeekVOList
    }
}

class NatureWeekVO {
    int dayOfWeek
    int weekOfYear

    int getDayOfWeek() {
        return dayOfWeek
    }

    void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek
    }

    int getWeekOfYear() {
        return weekOfYear
    }

    void setWeekOfYear(int weekOfYear) {
        this.weekOfYear = weekOfYear
    }


    @Override
    public String toString() {
        return "NatureWeekVO{" +
                "dayOfWeek=" + dayOfWeek +
                ", weekOfYear=" + weekOfYear +
                '}';
    }
}
