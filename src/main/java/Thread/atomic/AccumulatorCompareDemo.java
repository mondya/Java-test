package Thread.atomic;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

class ClickNumber {
    int number = 0;
    
    public synchronized void clickSynchronized() {
        number++;
    }
    
    AtomicLong atomicLong = new AtomicLong(0);
    public void clickAtomicLong() {
        atomicLong.getAndIncrement();
    }
    
    LongAdder longAdder = new LongAdder();
    public void clickLongAdder() {
        longAdder.increment();
    }
    
    LongAccumulator longAccumulator = new LongAccumulator(Long::sum, 0);
    public void clickAccumulator() {
        longAccumulator.accumulate(1);
    }
}

public class AccumulatorCompareDemo {

    public static final int _1W = 10000;
    
    public static final int THREAD = 50;
    
    public static void main(String[] args) throws Exception{
        ClickNumber clickNumber = new ClickNumber();
        
        long startTime;
        long endTime;

        CountDownLatch countDownLatch1 = new CountDownLatch(THREAD);
        CountDownLatch countDownLatch2 = new CountDownLatch(THREAD);
        CountDownLatch countDownLatch3 = new CountDownLatch(THREAD);
        CountDownLatch countDownLatch4 = new CountDownLatch(THREAD);
        
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= THREAD ; i++) {
            new Thread(() -> {
                try {
                    for (int j = 1; j <= 100 * _1W ; j++) {
                        clickNumber.clickSynchronized();
                    }
                } finally {
                    countDownLatch1.countDown();
                }
            }).start();
        }
        
        countDownLatch1.await();
        endTime = System.currentTimeMillis();
        System.out.println("synchronized cost: " + (endTime - startTime) + "毫秒" + "\t" + "result:" + clickNumber.number);


        startTime = System.currentTimeMillis();
        for (int i = 1; i <= THREAD ; i++) {
            new Thread(() -> {
                try {
                    for (int j = 1; j <= 100 * _1W ; j++) {
                        clickNumber.clickAtomicLong();
                    }
                } finally {
                    countDownLatch2.countDown();
                }
            }).start();
        }

        countDownLatch2.await();
        endTime = System.currentTimeMillis();
        System.out.println("clickAtomicLong cost: " + (endTime - startTime) + "毫秒" + "\t" + "result:" + clickNumber.atomicLong.get());


        startTime = System.currentTimeMillis();
        for (int i = 1; i <= THREAD ; i++) {
            new Thread(() -> {
                try {
                    for (int j = 1; j <= 100 * _1W ; j++) {
                        clickNumber.clickLongAdder();
                    }
                } finally {
                    countDownLatch3.countDown();
                }
            }).start();
        }

        countDownLatch3.await();
        endTime = System.currentTimeMillis();
        System.out.println("clickLongAdder cost: " + (endTime - startTime) + "毫秒" + "\t" + "result:" + clickNumber.longAdder.sum());


        startTime = System.currentTimeMillis();
        for (int i = 1; i <= THREAD ; i++) {
            new Thread(() -> {
                try {
                    for (int j = 1; j <= 100 * _1W ; j++) {
                        clickNumber.clickAccumulator();
                    }
                } finally {
                    countDownLatch4.countDown();
                }
            }).start();
        }

        countDownLatch4.await();
        endTime = System.currentTimeMillis();
        System.out.println("clickAccumulator cost: " + (endTime - startTime) + "毫秒" + "\t" + "result:" + clickNumber.longAccumulator.get());
    }
    
    
}
