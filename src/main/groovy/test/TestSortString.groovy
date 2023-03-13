package test

class TestSortString {
    static void main(String[] args) {
        List<PlaceVO> placeVOList = []
        PlaceVO placeVO = new PlaceVO(id: 215L, buildingId: 11L, layerCode: 4, doorPlateCode: 40001)
        PlaceVO placeVO1 = new PlaceVO(id: 221L, buildingId: 11L, layerCode: 4, doorPlateCode: 40002)
        
        PlaceVO placeVO2 = new PlaceVO(id: 238L, buildingId: 12L, layerCode: 5, doorPlateCode: 40004)
        PlaceVO placeVO3 = new PlaceVO(id: 240L, buildingId: 12L, layerCode: 5, doorPlateCode: 40005)
        
        PlaceVO placeVO4 = new PlaceVO(id: 216L, buildingId: 11L, layerCode: 5, doorPlateCode: 50003)
        PlaceVO placeVO5 = new PlaceVO(id: 230L, buildingId: 11L, layerCode: 5, doorPlateCode: 50014)
        PlaceVO placeVO6 = new PlaceVO(id: 211L, buildingId: 11L, layerCode: 5, doorPlateCode: 50014)
        
        placeVOList.add(placeVO)
        placeVOList.add(placeVO1)
        placeVOList.add(placeVO2)
        placeVOList.add(placeVO3)
        placeVOList.add(placeVO4)
        placeVOList.add(placeVO5)
        placeVOList.add(placeVO6)
        
        placeVOList.sort{a,b ->
            a.buildingId <=> b.buildingId ?: a.layerCode <=> b.layerCode ?: a.doorPlateCode <=> b.doorPlateCode ?: a.id <=> b.id
        }
        println placeVOList
    }
}
