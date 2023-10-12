package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit( () -> System.out.println("hello"), "success");
        executorService.shutdown();
    }
}
