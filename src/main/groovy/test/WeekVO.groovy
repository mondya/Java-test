package test


class WeekVO implements Serializable {
    private Long weekId;
    private Integer dayStamp;
    private Boolean top
    private Date date;
    private List<DayVO> dayVOList
    private String week;

    /*
    DayVO getDayVO() {
        return dayVO
    }

    void setDayVO(DayVO dayVO) {
        this.dayVO = dayVO
    }
*/

    Boolean getTop() {
        return top
    }

    Date getDate() {
        return date
    }

    void setDate(Date date) {
        this.date = date
    }

    void setTop(Boolean top) {
        this.top = top
    }

    WeekVO() {
    }
    
    String getWeek() {
        return week;
    }
    
    void setWeek(String s) {
        this.week = s;
    }

    WeekVO(Long weekId, Integer dayStamp) {
        this.weekId = weekId
        this.dayStamp = dayStamp
    }

    Long getWeekId() {
        return weekId
    }

    void setWeekId(Long weekId) {
        this.weekId = weekId
    }

    Long getDayStamp() {
        return dayStamp
    }

    void setDayStamp(Integer dayStamp) {
        this.dayStamp = dayStamp
    }


    @Override
    public String toString() {
        return "WeekVO{" +
                "weekId=" + weekId +
                ", dayStamp=" + dayStamp +
                ", top=" + top + ", week=" + week + 
                '}';
    }
}
