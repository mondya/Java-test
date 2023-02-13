package test

class TestGString {
    static void main(String[] args) {
        int i = 1;
        // GString不能作为Map的key
        Map map = [:]
        map.put("int_${i}", 1)

        println map.get("int_${i}")
        println map.get("int_1")
    }
    
}
