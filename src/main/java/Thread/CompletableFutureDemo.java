package Thread;

import java.util.concurrent.*;
import java.util.function.Function;


public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception{
//        FutureTask<String> stringFutureTask = new FutureTask<>(new MyThread2());
//        Thread thread = new Thread(stringFutureTask);
//        thread.start();

//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
//            System.out.println(Thread.currentThread().getName() + "...");
//            try {
//                Thread.sleep(5000L);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });

        ExecutorService thr = Executors.newFixedThreadPool(10);
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "...");
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("5s 后出结果");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            
            if (true) {
                throw new RuntimeException("exception");
            }

            return "hello";
        }, thr).whenComplete((a, exception) -> {
            System.out.println("计算完成" + exception);
        }).exceptionally(throwable -> "");

        
        
        thr.shutdown();
    }
}

class MineThread extends Thread {
    @Override
    public void run() {
        super.run();
    }
}

// 三个特点：多线程/有返回/异步任务
class MyThreadCallable implements Runnable{

    @Override
    public void run() {
        
    }
}

class MyThread2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return null;
    }
}
