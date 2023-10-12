package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {
    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(() -> {
            System.out.println("come in");
            LockSupport.park();
            System.out.println("唤醒");
        });
        t1.start();

        Thread.sleep(200);
        new Thread(() -> {
            LockSupport.unpark(t1);
        }).start();
    }
    
    
        private static void method2() {
        Lock lock = new ReentrantLock();

        Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("come in");
                condition.await();
                System.out.println("come in 2");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("发出通知");
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }
    
    private static void method1() {
        Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                try {
                    o.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            synchronized (o) {
                o.notify();
            }
        }).start();
    }
}
