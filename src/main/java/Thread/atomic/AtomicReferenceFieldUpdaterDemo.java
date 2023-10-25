package Thread.atomic;


import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicReferenceFieldUpdaterDemo {

    public static void main(String[] args) {
        MyVar myVar = new MyVar();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                myVar.init(myVar);
            }).start();
        }
    }
}

class MyVar {
    public volatile Boolean isInit = Boolean.FALSE;
    
    AtomicReferenceFieldUpdater<MyVar, Boolean> fieldUpdater = AtomicReferenceFieldUpdater.newUpdater(MyVar.class, Boolean.class, "isInit");
    
    public void init(MyVar myVar) {
        if (fieldUpdater.compareAndSet(myVar, Boolean.FALSE, Boolean.TRUE)) {
            System.out.println(Thread.currentThread().getName() + "\t" + "...start init");
            
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "\t" + "over init");
        } else {
            System.out.println(Thread.currentThread().getName() + "\t" + "已经有线程在进行Init操作");
        }
    }
}
