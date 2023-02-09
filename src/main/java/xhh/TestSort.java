package xhh;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

/**
 * @author xhh
 * @date 2021/12/20 16:24
 * 排序
 */
public class TestSort {
    public static void main(String[] args) {
        Date now = new Date();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(now));
        System.out.println(now.toInstant().atZone(ZoneOffset.ofHours(8)).toLocalDateTime().format(dateTimeFormatter));
        System.out.println(dateTimeFormatter.format(now.toInstant().atZone(ZoneOffset.ofHours(8)).toLocalDateTime()));
    }
}
