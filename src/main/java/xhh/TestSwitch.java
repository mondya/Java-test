package xhh;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.groovy.util.BeanUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author xhh
 * @date 2021/12/31 17:45
 */
public class TestSwitch {
    public static void main(String[] args) {
        String type = "支部";
        switch (type=="支部"?"支部":type){
            case "党委":
                System.out.println("党委");
                break;
            case "支部":
                System.out.println("支部");
                break;
            default:
                break;
        }
        String str = "[1,2,3,4]";
        List<Long> longs = JSONObject.parseArray(str, Long.class);
        System.out.println(longs);
    }
}
