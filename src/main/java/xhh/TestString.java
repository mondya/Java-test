package xhh;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.apache.groovy.util.BeanUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xhh
 * @date 2021/12/20 21:03
 */
public class TestString {
    public static void main(String[] args) {
        String str = ",张三,李四,王五,";
        String newStr = str.replaceAll("(^,)|(,$)","");
        System.out.println(newStr);
        System.out.println(str.contains(""));
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"hello");
        Multimap<String,Integer> multimap = HashMultimap.create();
        multimap.put("one",1);
        multimap.put("one",2);
        multimap.put("two" , 2);
        System.out.println(multimap);
        System.out.println(String.valueOf(str));
        
        String s = "厅局级";
        String s2 = "厅级";
        System.out.println(s.contains(String.valueOf(s2.charAt(0))));
        
        List<String> stringList = new ArrayList<>();
        stringList.add("66");
        stringList.add("77");
        stringList.add("99");
        stringList.add("88");
        stringList.add("100");
        String listStr = stringList.toString();
        System.out.println(listStr.replaceAll("(^\\[)|(\\]$)","").replaceAll(",","；"));
        
        List<String> list = new ArrayList<String>();
        list.add("t1");
        list.add("t2");
        list.add("t3");
        System.out.println(list.get(0));
        
        List<String> strings = new ArrayList<>();
        System.out.println("strings:"+strings.toString().replaceAll("(^\\[)|(\\]$)", ""));

        List<Long> longs = JSONArray.parseArray("[1,2,3]", Long.class);
        System.out.println(longs);
        String[] ids = {"1","2","3"};
        List<String> strings1 = Arrays.asList(ids);
        String[] objects = (String[]) strings1.toArray();
        System.out.println(Arrays.toString(objects));
        System.out.println(strings1);
    }
}
