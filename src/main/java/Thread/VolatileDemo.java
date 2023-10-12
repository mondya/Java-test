package Thread;

public class VolatileDemo {
    static volatile boolean  flag = Boolean.TRUE;

    public static void main(String[] args) {
        
        MyNum myNum = new MyNum();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myNum.add();
                }
            }, String.valueOf(i)).start();
        }
        
        try {
            Thread.sleep(2000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(myNum.number);
    }
    
    void m1() {
        new Thread(() -> {
            System.out.println("come in");
            while (flag) {

            }

            System.out.println("flag is false");
        }).start();


        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }

        flag = Boolean.FALSE;
    }
}

class MyNum {
    volatile int number;
    
    public synchronized void add() {
        number++;
    }
}
