package test

class TestOpt {
    static void main(String[] args) {
        hello("h")
    }

    static boolean compareFieldBit(int opt, int bit) {
        Integer type = Math.pow(2, opt - 1).intValue()
        (Integer.compare(bit & type, type) == 0)
    }

    static void hello(String s) {
        
        if (s == "hello") {
            throw new RuntimeException("参数异常")
        }
        try {
            if (s == 'h') {
                throw new RuntimeException("错误了")
            }
            String it = 's'
        } catch (Exception e){
            e.printStackTrace()
        } finally {
            println 'hello'
        }
    }
}
