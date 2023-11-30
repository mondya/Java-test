package Thread.threadLocal;

public class T1 {
    volatile boolean flag;

    public static void main(String[] args) {
        func1();
    }
    
    
    public static void func1() {
        ThreadLocal<String> t1 = new ThreadLocal<>();
        t1.set("xhh@gmail.com");
        t1.get();
    }
}
