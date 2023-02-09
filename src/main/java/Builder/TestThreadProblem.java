package Builder;

import java.util.concurrent.atomic.AtomicReference;

public class TestThreadProblem {
    //验证 在构造过程中JavaBean可能处于不一致的状态
    public static void main(String[] args) {
        //开启两个线程，一个对person进行赋值，一个获取person
        Person person = null;
        Thread thread1 = new Thread(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            person.setAge(23);
//            person.setName("张三");
//            person.setEmail("xxx@gmail.com");
//            person.setId(1001L);
        });

        
        Thread thread2 = new Thread(() -> {
//            person.setId(1200L);
//            person.setName("李四");
//            System.out.println(person.toString());
//            System.out.println("age:" + person.getAge());
//            System.out.println("name:" + person.getName());
        });
        thread1.start();
        thread2.start();
    }
}
