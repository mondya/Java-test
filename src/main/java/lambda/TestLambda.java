package lambda;

import com.google.common.collect.Table;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda表达式
 */
public class TestLambda {
    public static void main(String[] args) {
        //创建线程
        new Thread(() -> System.out.println("hello,world")).start();
        //排序
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Warning", "David Ferre",
                "Roger Federer", "Andy Murray",
                "Tomas Breach", "Juan Martin Del Petro",
                "Richard Gasket", "John Inner"};
        List<String> stringList = Arrays.asList(players);
        stringList.sort(Comparator.comparing(String::length));
        System.out.println(stringList);
        stringList.forEach(System.out::println);
        stringList.forEach(s->{
            System.out.println(s.length());
        });
        for (String s : stringList) {
            System.out.println(s.length());
        }
        
        
    }
}
