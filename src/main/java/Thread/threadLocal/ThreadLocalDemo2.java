package Thread.threadLocal;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo2 {
    
    public static void main(String[] args) {

        MyData myData = new MyData();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            CompletableFuture.runAsync(() -> {
                try {
                    Integer before = myData.threadLocal.get();
                    myData.add();
                    Integer after = myData.threadLocal.get();

                    System.out.println(Thread.currentThread() + "> before: " + before + " after: " + after);
                } finally {
                    myData.threadLocal.remove();
                }
            }, threadPool);
        }
        
        threadPool.shutdown();
        
    }
}

class MyData {
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
    
    public void add() {
        threadLocal.set(1 + threadLocal.get());
    }
}
