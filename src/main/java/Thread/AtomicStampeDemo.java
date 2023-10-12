package Thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicStampedReference;

@NoArgsConstructor
@AllArgsConstructor
@Data
class Book {
    private int id;
    private String name;
}

public class AtomicStampeDemo {
    public static void main(String[] args) {
        Book a = new Book(1, "java");
        AtomicStampedReference<Book> atomicStampedReference = new AtomicStampedReference<>(a, 1);
        System.out.println(atomicStampedReference.getReference() + "\t" + atomicStampedReference.getStamp());
        
        Book b = new Book(2, "mysql");
        boolean flag;
        
        flag = atomicStampedReference.compareAndSet(a, b, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
        System.out.println(flag + "\t" + atomicStampedReference.getReference() + "\t" + atomicStampedReference.getStamp());
        
        flag = atomicStampedReference.compareAndSet(b, a, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
        System.out.println(flag + "\t" + atomicStampedReference.getReference() + "\t" + atomicStampedReference.getStamp());
    }
}
