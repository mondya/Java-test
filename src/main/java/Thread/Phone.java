package Thread;

public class Phone {
    public synchronized void sendEmail() {
        System.out.println("send email");
    }
    
    public synchronized void sendSms() {
        System.out.println("send sms");
    }
}

/**
 * 
 */

class Lock8Demo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            phone.sendEmail();
        }, "a").start();

        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        new Thread(() -> {
            phone2.sendSms();
        }, "b").start();
        
    }
}
