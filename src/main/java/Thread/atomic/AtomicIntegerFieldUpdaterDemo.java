package Thread.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterDemo {
    public static void main(String[] args) throws Exception{
        Bank bank = new Bank();

        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    for (int j = 1; j <=1000 ; j++) {
                        bank.transformMoney(bank);
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
        
        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + "result: " + bank.money);
    }
}

class Bank {
    String bankName = "CCB";
    // 更新的对象属性必须使用public volatile 修饰符
    public volatile int money = 0;
    
    // 因为对象的属性修改类型原子类都是抽象类，所以每次使用都必须使用静态方法newUpdater()创建一个更新器，并且需要设置想要更新的类和属性
    
    AtomicIntegerFieldUpdater<Bank> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Bank.class, "money");
    
    // 不使用synchronized，保证高性能原子性
    public void transformMoney(Bank bank) {
        fieldUpdater.getAndIncrement(bank);
    }
}
