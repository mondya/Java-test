package test

class TestFor {
    static void main(String[] args) {

        List<Long> ids = [1,2]

        for (Long id in ids) {
            if (id == 1) {
                continue
            }
            
            println id
        }
    }
}
