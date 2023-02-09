package stream;


import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xhh
 * @date 2021/12/24 10:16
 * java8 stream流
 *
 */
public class TestStream {
    public static void main(String[] args) {
        String[] strings = {"one", "two", "three", "five", "", "four", "four", "two"};
        BigDecimal[] number = {BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO};
        List<BigDecimal> numbers = Arrays.asList(number);
        BigDecimal reduce2 = numbers.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        Double[] doubles = {1.1, 1.2, 1.3};
        List<Double> doubleList = Arrays.asList(doubles);
        DoubleSummaryStatistics collect2 = doubleList.stream().collect(Collectors.summarizingDouble(d -> d));
        Optional<Double> reduce4 = doubleList.stream().reduce(Double::sum);
        System.out.println("reduce4:" + reduce4.get());
        System.out.println("reduce2:" + reduce2);
        List<String> list = Arrays.asList(strings);
        //     List<String> stringsList = list.stream().map(s -> s.substring(0,2)).collect(Collectors.toList());
        String[] array = list.toArray(new String[0]);
        System.out.println("array=" + Arrays.toString(array));
        ArrayList<Object> arrayList = new ArrayList<>();
        //过滤
        List<String> stringList = list.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("stringList" + stringList);
        //去重+过滤
        List<String> distinctList = list.stream().distinct()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toList());
        System.out.println("distinctList:" + distinctList);
        //截取,截取个数
        List<String> limitList = list.stream().limit(3)
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toList());
        System.out.println("limitList:" + limitList);

        //排序
        
        List<String> sortList = list.stream().filter(string -> !string.isEmpty()).sorted((String a, String b) -> Integer.compare(a.length(), b.length())).collect(Collectors.toList());
        System.out.println("sortList:" + sortList);
        list.sort(Comparator.comparing(String::length));
        list.sort((String a, String b) -> Integer.compare(a.length(), b.length()));
        System.out.println("list:" + list);
        //转换map
        List<Pair<String, BigDecimal>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("version", BigDecimal.valueOf(6.19)));
        pairArrayList.add(new Pair<>("version", new BigDecimal("10.24")));
        pairArrayList.add(new Pair<>("version", BigDecimal.valueOf(13.14)));
        pairArrayList.add(new Pair<>("upVersion", BigDecimal.valueOf(111.11)));
        pairArrayList.add(new Pair<>("newVersion", BigDecimal.valueOf(1.1)));
        pairArrayList.stream().max(Comparator.comparing(s->s.versionNumber)).get();
        //遍历
        pairArrayList.forEach(p -> {
            p.version = p.version + "hello";
        });
        System.out.println("遍历" + pairArrayList);
        List<BigDecimal> collect1 = pairArrayList.stream().map(Pair::getVersionNumber).collect(Collectors.toList());
        System.out.println("collect1=" + collect1);
        //Map<String, BigDecimal> collect3 = pairArrayList.stream().collect(Collectors.toMap(p -> p.version, p -> p.versionNumber));
        //排序
        pairArrayList.sort(Comparator.comparing(p -> p.version.length()));
        System.out.println("排序之后的pairArrayList:" + pairArrayList);
        Pair<String, BigDecimal> stringBigDecimalPair = pairArrayList.stream().max(Comparator.comparing(Pair::getVersionNumber)).get();
        System.out.println("stringBigDecimalPair:" + stringBigDecimalPair);
        //分组
        Map<String, List<Pair<String, BigDecimal>>> map = pairArrayList.stream().collect(
                Collectors.groupingBy(Pair::getVersion)
        );
        for (Map.Entry<String, List<Pair<String, BigDecimal>>> entry : map.entrySet()) {
            Integer count = entry.getValue().size();
            System.out.println(count);
        }
        System.out.println("GroupMap:" + map);
        DoubleSummaryStatistics collect = null;
        for (Map.Entry<String, List<Pair<String, BigDecimal>>> entry : map.entrySet()) {
            List<Pair<String, BigDecimal>> value = entry.getValue();
//            collect = value.stream().collect(Collectors.reducing(BigDecimal::add)).get();
            BigDecimal reduce = value.stream().map(Pair::getVersionNumber).reduce(BigDecimal.ZERO, BigDecimal::add);
            Optional<BigDecimal> reduce1 = value.stream().map(Pair::getVersionNumber).reduce(BigDecimal::add);
            Optional<BigDecimal> reduce3 = value.stream().map(Pair::getVersionNumber).reduce(BigDecimal::max);
            System.out.println("reduce3" + reduce3.get());
            System.out.println(reduce1.get());
        }
        if (collect != null) {
            System.out.println(collect.getSum());
        }
        if (collect != null) {
            double average = collect.getAverage();
            BigDecimal bigDecimal = BigDecimal.valueOf(average);
            /*
             * ROUND_HALF_UP : 四舍五入
             * ROUND_HALF_DOWN : 五舍六入,就近原则，<=5 舍去，>5进一位
             * ROUND_UP : 直接进1位
             * ROUND_DOWN : 直接去掉尾数
             */
            System.out.println(bigDecimal);
            System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_DOWN));
            pairArrayList.stream().peek(p -> p.setVersionNumber(BigDecimal.ZERO)).forEach(System.out::println);
            BigDecimal reduce = pairArrayList.stream().map(Pair::getVersionNumber).reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }
}
