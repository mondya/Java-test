package test;

import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Classname MorseCode
 * @Description TODO
 * @Date 2021/7/24 9:25
 * @Created by Mr.He
 * TODO 摩斯密码
 */
public class MorseCode {
    final int ZERO = 0;
    final int ONE = 1;

    public String transform(String[] value, int dense) {
        AtomicReference<String> result = new AtomicReference<>("");
        int j = 0;
        for (String s :
                value) {
            if (Objects.equals(dense, ZERO)) {
                if (!morseCodeTable().containsKey(s)) {
                    return null;
                }
                j = 0;
            }
            if (Objects.equals(dense, ONE)) {
                if (!morseCodeTable().containsValue(s)) {
                    return null;
                }
                j = 1;
            }

            int finalJ = j;
            morseCodeTable().forEach((k, v) -> {
                if(Objects.equals(finalJ,ZERO)){
                    if (Objects.equals(k, s.toUpperCase())) {
                        result.updateAndGet(v1 -> v1 + v + " ");
                    }
                }else{
                    if (Objects.equals(v, s)) {
                        result.updateAndGet(v1 -> v1 + k + " ");
                    }
                }
            });
        }
        return result.toString();
    }


    /*
     * TODO 程序主体
     *  dense 加密解密标识   0：加密 1：解密
     *  value 密文
     * */
    public String mainBodyOfTheProgram(String value, int dense) {
        if (value == null) {
            return null;
        }
        String[] strings = value.split(" ");
        return transform(strings, dense);
    }


    public static Map morseCodeTable() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "•—");
        map.put("B", "—•••");
        map.put("C", "—•—•");
        map.put("D", "—••");
        map.put("E", "•");
        map.put("F", "••—•");
        map.put("G", "——•");
        map.put("H", "••••");
        map.put("I", "••");
        map.put("J", "•———");
        map.put("K", "—•—");
        map.put("L", "•—••");
        map.put("M", "——");
        map.put("N", "—•");
        map.put("O", "———");
        map.put("P", "•——•");
        map.put("Q", "——•—");
        map.put("R", "•—•");
        map.put("S", "•••");
        map.put("T", "—");
        map.put("U", "••—");
        map.put("V", "•••—");
        map.put("W", "•——");
        map.put("X", "—••—");
        map.put("Y", "—•——");
        map.put("Z", "——••");
        map.put("1", "•————");
        map.put("2", "••———");
        map.put("3", "•••——");
        map.put("4", "••••—");
        map.put("5", "•••••");
        map.put("6", "—••••");
        map.put("7", "——•••");
        map.put("8", "———••");
        map.put("9", "————•");
        map.put("0", "—————");
        map.put("?", "••——••");
        map.put("/", "—••—•");
        map.put("()", "—•——•—");
        map.put("—", "—••••—");
        map.put("•", "•—•—•—");
        return map;
    }

    public static void main(String[] args) {
        MorseCode morseCode = new MorseCode();
        System.out.println("摩斯密码加密："+morseCode.mainBodyOfTheProgram("• E",0));
        System.out.println("摩斯密码解密："+morseCode.mainBodyOfTheProgram("•—•—•— •",1));

        System.out.println("加密"+ morseCode.mainBodyOfTheProgram("H E L L O W O R L D", 0));

//        System.out.println (JSONObject.toJSONString(morseCodeTable()));


    }
}

