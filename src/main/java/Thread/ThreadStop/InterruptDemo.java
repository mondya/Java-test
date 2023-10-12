package Thread.ThreadStop;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class InterruptDemo {
    static volatile boolean isStop = false;
    
    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) {
        int andIncrement = new AtomicInteger(3).incrementAndGet();
        System.out.println(andIncrement);
//        Thread t1 = new Thread(() -> {
//            while (true) {
//                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println("isInterrupted 被设置为" +Thread.currentThread().isInterrupted() + "，停止");
//                    break;
//                }
//
//                System.out.println("hello isInterrupted");
//            }
//        });
//        t1.start();
//
//        try {
//            Thread.sleep(20);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        new Thread(t1::interrupt).start();
    }
    
    public void test01() {
        new Thread(() -> {
            while (true) {
                if (isStop) {
                    System.out.println("isStop被设置为true，停止");
                    break;
                }

                System.out.println("hello volatile");
            }
        }).start();

        try {
            Thread.sleep(20);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            isStop = true;
        }).start();
    }
}
