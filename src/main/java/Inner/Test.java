package Inner;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author xhh
 * @date 2022/3/2 15:05
 */
public class Test {
    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("2");
        List<BigDecimal> list = new ArrayList<BigDecimal>();
        list.add(bd.multiply(BigDecimal.valueOf(list.size())));
        list.add(BigDecimal.valueOf(2));
        list.add(BigDecimal.valueOf(3));
        List<BigDecimal> list2 = new ArrayList<>();
        list2 = list;
        Optional<BigDecimal> reduce = list.stream().reduce(BigDecimal::add);
        BigDecimal reduce1 = list.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce.get());
        System.out.println(list2);
        System.out.println(new Date(1633363200000L));
    }
}
