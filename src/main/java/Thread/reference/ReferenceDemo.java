package Thread.reference;


import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;

public class ReferenceDemo {
    public static void main(String[] args) {
//        MyObject myObject = new MyObject();
//
//        System.out.println("gc before" + myObject);
//        
//        myObject = null;
//        
//        System.gc();
//        
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("gc after" + myObject);

//        SoftReference<MyObject> myObjectSoftReference = new SoftReference<>(new MyObject());
//        System.gc();
//        
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        
//        System.out.println("gc after 内存够用" + myObjectSoftReference.get());
//        
//        
//        try {
//            byte[] bytes = new byte[20 * 1024 * 1024]; // 20m
//        } catch (OutOfMemoryError e) {
//            System.out.println("内存不够用了");
//        } finally {
//            System.out.println("myObjectSoftReference-->" + myObjectSoftReference.get());
//        }

//        WeakReference<MyObject> myObjectWeakReference = new WeakReference<>(new MyObject());
//        System.out.println("gc before 内存够用" + myObjectWeakReference.get());
//        
//        System.gc();
//        
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("gc after 内存够用" + myObjectWeakReference.get());

        MyObject myObject = new MyObject();
        ReferenceQueue<MyObject> referenceQueue = new ReferenceQueue<>();
        PhantomReference<MyObject> phantomReference = new PhantomReference<>(myObject, referenceQueue);
        
        List<byte[]> list = new ArrayList<>();
        
        new Thread(() -> {
            while (true) {
                list.add(new byte[1 * 1024 * 1024]);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(phantomReference.get() + "list add ok");
            }
        }).start();
        
        new Thread(() -> {
            while (true) {
                Reference<? extends MyObject> poll = referenceQueue.poll();
                if (poll != null) {
                    System.out.println("对象回收");
                    break;
                }
            }
        }).start();
    }
}


class MyObject {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("------invoke finalize method");
    }
}