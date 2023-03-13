package test

import lombok.Data

class PlaceVO implements Serializable{
    Long id
    // 班牌点位，排序使用
    Long buildingId
    // 楼层code
    Integer layerCode

    Integer doorPlateCode

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    Long getBuildingId() {
        return buildingId
    }

    void setBuildingId(Long buildingId) {
        this.buildingId = buildingId
    }

    Integer getLayerCode() {
        return layerCode
    }

    void setLayerCode(Integer layerCode) {
        this.layerCode = layerCode
    }

    Integer getDoorPlateCode() {
        return doorPlateCode
    }

    void setDoorPlateCode(Integer doorPlateCode) {
        this.doorPlateCode = doorPlateCode
    }


    @Override
    public String toString() {
        return "PlaceVO{" +
                "id=" + id +
                ", buildingId=" + buildingId +
                ", layerCode=" + layerCode +
                ", doorPlateCode=" + doorPlateCode +
                '}';
    }
}
