package Thread.suncUp;

import org.openjdk.jol.info.ClassLayout;

public class SynchronizedUpDemo {
    public static void main(String[] args) {
        Object o = new Object();
//        System.out.println("hashCode=" + o.hashCode());
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
