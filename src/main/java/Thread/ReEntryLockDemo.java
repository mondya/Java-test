package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntryLockDemo {
    
    static Lock lock = new ReentrantLock();
    
    public static void main(String[] args) {
        
//        final Object o = new Object();
//        
//        new Thread(() -> {
//            synchronized(o) {
//                System.out.println("外部调用");
//                synchronized (o) {
//                    System.out.println("中间调用");
//                    synchronized(o) {
//                        System.out.println("最后调用");
//                    }
//                }
//            }
//        }).start();
        
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("外层调用");
                lock.lock();
                try {
                    System.out.println("内层调用");
                    lock.lock();
                } finally {
                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }
            
            lock.unlock();
        }).start();
        
    }
}
