package Thread.readWrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) {
        MyResource myResource = new MyResource();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> myResource.write(finalI + "", "" + finalI), String.valueOf(i)).start();
        }

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> myResource.read(finalI + ""), String.valueOf(i)).start();
        }
        
        for (int i = 0; i < 2; i++) {
            new Thread(() -> myResource.write("1", "1"), "新线程" + String.valueOf(i)).start();
        }
    }
}


class MyResource {
    Map<String ,String> map = new HashMap<>();

    ReentrantLock lock = new ReentrantLock();

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void write(String key, String value) {
        readWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "：正在写入");
            map.put(key, value);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }



    public void read(String key) {
        readWriteLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "：正在读取");
            String s = map.get(key);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "完成读取:" + s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}