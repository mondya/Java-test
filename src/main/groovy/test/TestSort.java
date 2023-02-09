package test;

import org.apache.tools.ant.types.resources.Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestSort {
    public static void main(String[] args) {
        List<SortTest> sortTestList = new ArrayList<>();
        sortTestList.add(new SortTest(2L,1,true,"张三"));
        sortTestList.add(new SortTest(1L,2,false,"李四"));
        sortTestList.add(new SortTest(3L,2,true,"小五"));
        sortTestList.add(new SortTest(1L,1,false,"666"));
        
        List<SortTest> list = sortTestList.stream().sorted(Comparator.comparing((SortTest s) -> !s.getTop()).thenComparing(n -> -n.getIdx())).collect(Collectors.toList());
        //sortTestList.sort(Comparator.comparing(s -> s.getIdx()));
        System.out.println(sortTestList);
        System.out.println(list);
        List<SortTest> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }
}
