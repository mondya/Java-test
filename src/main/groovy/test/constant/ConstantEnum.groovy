package test.constant

enum ConstantEnum {
    static enum SectionType {

        KINDERGARTEN(1L, "幼儿园"),

        PRIMARY_SCHOOL(3L, "小学"),

        MIDDLE_SCHOOL(5L, "初中"),

        SPECIALIZED_SCHOOL(6L, "中专"),

        HIGH_SCHOOL(7L, "高中"),

        COLLEGE_SCHOOL(8L, "大专"),

        UNIVERSITY(9L, "大学"),

        VOCATIONAL_SCHOOL(10L, "中职")

        public Long id

        public String name

        SectionType(Long id, String name) {
            this.id = id
            this.name = name
        }

        static List<SectionType> getAllEnumByTypes(String types) {
            List<SectionType> sectionTypeList = []
            if (types) {
                types.split(',').each {
                    SectionType sectionType = getEnumByType(it as Long)
                    if (sectionType) {
                        sectionTypeList << sectionType
                    }
                }
            }
            sectionTypeList
        }

        static String getNameBySectionIdAndCodeAndSectionType(Long sectionId, Integer code, Byte sectionType) {
//            String name = ToStringUnits.getChinese(code.toString()) + "年级"
            if (sectionType == 1 as byte) {
                switch (sectionId) {
                    case KINDERGARTEN.id:
                        if (sectionType == 1 as byte && code < 4) {
                            String[] names = ["小班", "中班", "大班"]
//                            name = names[code - 1]
                        }
                        break
                    case PRIMARY_SCHOOL.id:
                        break
                    case MIDDLE_SCHOOL.id:
//                        name = "初" + ToStringUnits.getChinese(code.toString())
                        break
                    case SPECIALIZED_SCHOOL.id:
//                        name = "专" + ToStringUnits.getChinese(code.toString())
                        break
                    case HIGH_SCHOOL.id:
//                        name = "高" + ToStringUnits.getChinese(code.toString())
                        break
                    case COLLEGE_SCHOOL.id:
//                        name = "专" + ToStringUnits.getChinese(code.toString())
                        break
                    case UNIVERSITY.id:
//                        name = "大" + ToStringUnits.getChinese(code.toString())
                        break
                    case VOCATIONAL_SCHOOL.id:
//                        name = "职" + ToStringUnits.getChinese(code.toString())
                        break
                }
            }
//            name
        }

        static SectionType getEnumByType(Long id) {
            for (SectionType s : values()) {
                if (s.id == id) {
                    return s
                }
            }
            return null
        }

    }
}