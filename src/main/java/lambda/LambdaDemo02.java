package lambda;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaDemo02 {
    public static void main(String[] args) {
        List<Author> authors = getAuthors();
        
//        authors.stream().distinct().filter(new Predicate<Author>() {
//            @Override
//            public boolean test(Author author) {
//                System.out.println("test");
//                return author.getAge() < 18;
//            }
//        }).forEach(new Consumer<Author>() {
//            @Override
//            public void accept(Author author) {
//                System.out.println(author.getName());
//            }
//        });
        
        // 参数类型可以省略，方法只有一个参数时小括号可以省略，代码只有一行时return和大括号可以省略
//        authors.stream().distinct().filter(author -> author.getAge() < 18).forEach(System.out::println);
        Map<Long, Author> collect = authors.stream().distinct().collect(Collectors.toMap(Author::getId, v -> v));
        Map<Long, List<Author>> collect1 = authors.stream().collect(Collectors.groupingBy(Author::getId));
//        System.out.println(collect);
        
//        testFlatMap();

//        testCollectMap();

//        testReduceMaxMin();
//        testReduce();
//        testReduceList();
//        testAnd();

//        testMethod("hello", String::substring);
        testArray();
    }
    
    public static void testArray() {
        Integer[] integers = {1,2,3,4};
        Arrays.stream(integers).distinct().filter( i -> i > 2).forEach(System.out::println);
        Arrays.stream(integers).parallel().map(s -> String.valueOf(s) + Thread.currentThread().getName()).forEach(System.out::println);
//        Stream.of(integers).distinct().filter(i -> i > 2).forEach(System.out::println);
    }
    
    private static void testMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        entries.stream().filter( entry -> entry.getKey().length() > 1).forEach(System.out::println);
    }
    
    private static void testFlatMap() {
        List<Author> authors = getAuthors();
        authors.stream().flatMap(s -> s.getBookList().stream()).flatMap(s -> Arrays.stream(s.getCategory().split("，"))).distinct().forEach(System.out::println);
    }
    
    private static void testCollectMap() {
        List<Author> authors = getAuthors();
        Map<Integer, List<Book>> collect = authors.stream().distinct().collect(Collectors.toMap(s -> s.getName().length(), Author::getBookList));
        System.out.println(collect);
    }
    
    private static void testAnd() {
        List<Author> authors = getAuthors();
        authors.stream().filter( s -> s.getAge() > 13 && StringUtils.isNoneBlank(s.getName()) && s.getName().length() > 1).forEach(System.out::println);
    }
    
    private static void testReduce() {
        List<Author> authors = getAuthors();
        Integer reduce = authors.parallelStream().map(Author::getAge).reduce(1, Integer::sum, (a, b) -> a * b);
        System.out.println(reduce);
    }
    
    private static void testReduceMaxMin() {
        List<Author> authors = getAuthors();
        Integer min = authors.stream().map(Author::getAge).reduce(Integer.MAX_VALUE, (result, element) -> result < element ? result : element);
        System.out.println(min);

        Integer max = authors.stream().map(Author::getAge).reduce(Integer.MIN_VALUE, (result, element) -> result > element ? result : element);
        System.out.println(max);
    }
    
    private static void testReduceList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
        Integer reduce = list.parallelStream().reduce(0, (x1, x2) -> x1 + x2);
        System.out.println(reduce);


        Integer v4 = list.stream().reduce(0,
                (x1, x2) -> {
                    return x1 - x2;
                });
        System.out.println(v4);
    }
    
    private static void testStatic() {
        List<Author> authors = getAuthors();
        List<String> collect = authors.stream().map(s -> s.getId()).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) {
                return String.valueOf(aLong);
            }
        }).collect(Collectors.toList());
        List<String> collect1 = authors.stream().map(s -> String.valueOf(s.getId())).collect(Collectors.toList());
        // 转换成
        authors.stream().map(Author::getId).map(String::valueOf).collect(Collectors.toList());
    }
    
    private static void testMethod(String str, UseString useString) {
        int start = 0;
        int end = 1;
        useString.subStr(str, start, end);
    }
    
    
    interface UseString{
        String subStr(String str, int start, int end);
    }
        
        
        
    
    private static List<Author> getAuthors() {
        Author author = new Author(1L, null, 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "呀拉索", 15, "狂风中也追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界再限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界再限制他的思维", null);
        
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();
        
        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学，爱情", 88, "用一把刀划分了爱情"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长，爱情", 99, "用一把刀划分了爱情"));
        
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情，个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));
        
        books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L, "风与剑", "个人传记", 56, "两个哲学家灵魂和肉体的碰撞会激起怎样的火花呢？"));
        books3.add(new Book(6L, "风与剑", "个人传记", 56, "两个哲学家灵魂和肉体的碰撞会激起怎样的火花呢？"));
        
        author.setBookList(books1);
        author2.setBookList(books2);
        author3.setBookList(books3);
        author4.setBookList(books3);

        return new ArrayList<>(Arrays.asList(author, author2, author3, author4));
    }
}
