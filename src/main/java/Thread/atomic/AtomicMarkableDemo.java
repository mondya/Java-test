package Thread.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMarkableDemo {
    public static void main(String[] args) {
        AtomicMarkableReference<Integer> markableReference = new AtomicMarkableReference<>(100, false);
        
        new Thread(() -> {
            boolean marked = markableReference.isMarked();
            System.out.println(Thread.currentThread().getName() + "默认标识" + marked);
            
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            markableReference.compareAndSet(100, 1000, marked, !marked);
            
        }).start();
        
        new Thread(() -> {
            boolean marked = markableReference.isMarked();
            System.out.println(Thread.currentThread().getName() + "默认标识" + marked);

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            boolean b = markableReference.compareAndSet(100, 2000, marked, !marked);

            System.out.println(Thread.currentThread().getName() + "cas result:" +  b);
            System.out.println(Thread.currentThread().getName() + "mark:" +  markableReference.isMarked());
            System.out.println(Thread.currentThread().getName() + "value: " +  markableReference.getReference());
        }).start();
    }
}
