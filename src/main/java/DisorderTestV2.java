import java.util.HashSet;
import java.util.Set;

public class DisorderTestV2 {

    static int x = 0;
    static int y = 0;
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws Exception {

        Set<String> result = new HashSet<>();

        for (int i = 0; i < 1000000; i++) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            Thread one = new Thread(() -> {
                a = y;
                x = 1;
            });

            Thread two = new Thread(() -> {
                b = x;
                y = 1;
            });

            one.start();
            two.start();

            one.join();
            two.join();

            result.add(String.format("a = %s,b = %s", a, b));
            System.out.println(result);
        }
    }
}
