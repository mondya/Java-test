package Thread.atomic;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderDemo {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        
        longAdder.increment();
        longAdder.increment();
        longAdder.increment();

        System.out.println(longAdder);

        LongAccumulator longAccumulator = new LongAccumulator(Long::sum, 0);
        
        longAccumulator.accumulate(2);
        longAccumulator.accumulate(10);
        System.out.println(longAccumulator.get());
    }
}
