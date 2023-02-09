package test

import com.alibaba.fastjson.annotation.JSONField

class DayVO {
    private Long id
    private Long dayOfWeek;

    DayVO(){}
    
    DayVO(Long id, Long dayOfWeek){
        this.id = id
        this.dayOfWeek = dayOfWeek
    }
    
    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    Long getDayOfWeek() {
        return dayOfWeek
    }

    void setDayOfWeek(Long dayOfWeek) {
        this.dayOfWeek = dayOfWeek
    }


    @Override
    public String toString() {
        return "DayVO{" +
                "id=" + id +
                ", dayOfWeek=" + dayOfWeek +
                '}';
    }
}
