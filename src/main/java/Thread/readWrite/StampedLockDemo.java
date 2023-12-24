package Thread.readWrite;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    static int number = 37;
    static StampedLock stampedLock = new StampedLock();

    public void write() {
        long stamp = stampedLock.writeLock();
        System.out.println(Thread.currentThread().getName() + "写线程准备修改");

        try {
            number = number + 13;
        } finally {
            stampedLock.unlockWrite(stamp);
        }

        System.out.println(Thread.currentThread().getName() + "写线程修改完毕");
    }


    public void read() {
        long stamp = stampedLock.readLock();
        System.out.println(Thread.currentThread().getName() + "读线程准备读取");

        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "读线程睡眠1秒正在读取中");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            int result = number;
            System.out.println(Thread.currentThread().getName() + "读线程读取结果：" + result);
            System.out.println("写线程没有修改成功，读锁时写锁无法介入，传统的读写互斥");

        } finally {
            stampedLock.unlockRead(stamp);
        }
    }

    public void tryOptimisticRead() {
        long stamp = stampedLock.tryOptimisticRead();
        int result = number;

        // 故意间隔4秒，乐观认为读取过程中没有其他线程修改number值
        System.out.println("4s前stampedLock.validate方法值（true无修改，false有修改）" + stampedLock.validate(stamp));
        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "正在读取" + i + "秒" + "后stampLock.validate方法值：" + stampedLock.validate(stamp));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (!stampedLock.validate(stamp)) {
            System.out.println("有写操作发生");
            stamp = stampedLock.readLock();

            try {
                System.out.println("从乐观锁升级为悲观锁");

                result = number;

                System.out.println("重新悲观读后result:" + result);
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }

        System.out.println("read final result:" + result);
    }

    public static void main(String[] args) {
        StampedLockDemo stampedLockDemo = new StampedLockDemo();
//        new Thread(() -> {
//            stampedLockDemo.read();
//        }, "readThread").start();
        new Thread(() -> {
            stampedLockDemo.tryOptimisticRead();
        }, "readThread").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "come in");
            stampedLockDemo.write();
        }, "writeThread").start();
    }
}
