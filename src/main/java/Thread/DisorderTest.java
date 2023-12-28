package Thread;

import java.util.concurrent.Semaphore;

/**
 * 指令重排测试
 */
public class DisorderTest {
    int a = 0;
    boolean flag = false;
    
    
    public void write() {
        a = 1;
        flag = true;
    }
    
    
    public void read() {
        if (flag) {
            if (a == 0) {
                System.out.println("发生了指令重排。。");
            }
        }
    }


    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(100);
        
        for (;;) {
            DisorderTest disorderTest = new DisorderTest();
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    disorderTest.read();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    disorderTest.write();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
