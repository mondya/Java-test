package Thread;

public class DoubleCheckDemo {
    private static volatile DoubleCheckDemo instance;
    
    private DoubleCheckDemo() {
    }
    
    
    public static DoubleCheckDemo getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckDemo.class) {
                if (instance == null) {
                    instance = new DoubleCheckDemo();
                }
            }
        }
        
        return instance;
    }
}
