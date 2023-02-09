package Builder;

public class MyThread extends Thread{
    public void run(Person person){
        person = new Person.Builder().age(44).name("老六").build();
    }
}
