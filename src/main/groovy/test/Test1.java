package test;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        String ids = "1,2, ,4";
        /*
        String[] split = ids.split(",");
        List<String> idList = Arrays.asList(split);
        List<Long> collect = idList.stream().filter((String s) -> !StringUtils.isBlank(s)).map(Long::parseLong).collect(Collectors.toList());
        System.out.println("collect:"+collect);
        System.out.println(idList);
        System.out.println(Arrays.toString(split));
         */
        Pattern p = Pattern.compile("^0?(13|14|15|16|18|17|19)[0-9]{9}\\$");
        Matcher matcher = p.matcher("19967152962");
        boolean matches = matcher.matches();
        System.out.println(matches);
    }

    static Date strToDate(String dateTimeStr, String formatStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }
}
