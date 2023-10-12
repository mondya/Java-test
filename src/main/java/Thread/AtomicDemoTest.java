package Thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;

@NoArgsConstructor
@AllArgsConstructor
@Data
class User {
    private int age;
    private String name;
}

public class AtomicDemoTest {
    public static void main(String[] args) {
        AtomicReference<User> atomicReference = new AtomicReference<>();

        User a = new User(12, "a");
        User b = new User(13, "b");
        
        atomicReference.set(a);

        System.out.println(atomicReference.compareAndSet(a, b) + "\t" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(a, b) + "\t" + atomicReference.get().toString());
    }
}
