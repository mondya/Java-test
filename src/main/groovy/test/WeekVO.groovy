package test


class WeekVO implements Serializable {
    private Long weekId;
    private Long dayStamp;
    private Boolean top
    private Date date;
    private List<DayVO> dayVOList

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

    WeekVO(Long weekId, Long dayStamp) {
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

    void setDayStamp(Long dayStamp) {
        this.dayStamp = dayStamp
    }


    @Override
    public String toString() {
        return "WeekVO{" +
                "weekId=" + weekId +
                ", dayStamp=" + dayStamp +
                ", top=" + top +
                '}';
    }
}
