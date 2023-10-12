package Thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockDemo {
    
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    
    public void lock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "come in");
        while (!atomicReference.compareAndSet(null, thread)) {
            
        }
    }
    
    public void unlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.getName() + "unlock");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        
        new Thread(() -> {
            spinLockDemo.lock();
            
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            spinLockDemo.unlock();
        }).start();
        
        
        new Thread(() -> {
            spinLockDemo.lock();
            spinLockDemo.unlock();
        }).start();
    }
}
