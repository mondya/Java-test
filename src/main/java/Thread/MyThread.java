package Thread;

import lombok.extern.slf4j.Slf4j;


/**
 * @author xhh
 * @date 2022/2/7 10:38
 */
//创建死锁
@Slf4j
public class MyThread {
    
    public static void main(String[] args) {
        Object objectOne = new Object();
        Object objectTwo = new Object();
        Thread t1 = new Thread(){
            public void run(){
                System.out.println("Lock1 is running");
                try {
                    synchronized (objectOne){
                        Thread.sleep(3000);
                        System.out.println("Lock1 get objectOne");
                        synchronized (objectTwo){
                            System.out.println("Lock1 get objectTwo");
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        
        Thread t2 = new Thread(){
            public void run(){
                System.out.println("Lock2 is running");
                try {
                    synchronized (objectTwo){
                        Thread.sleep(3000);
                        System.out.println("Lock2 get objectTwo");
                        synchronized (objectOne){
                            System.out.println("Lock2 get objectOne");
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        
        Thread t3 = new Thread(){
            public void run(){
                
            }
        };
        //线程的执行顺序是随机的
        t1.start();
        t2.start();
    }
    public synchronized void payTicket(){
        
    }
}
