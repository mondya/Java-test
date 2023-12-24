package Thread.readWrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDownDemo {

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        
//        readLock.lock();
//        System.out.println("读取");
//        readLock.unlock();




        writeLock.lock();
        System.out.println("写入");

        readLock.lock();
        System.out.println("读取");


        readLock.unlock();
        writeLock.unlock();
        
    }
}
