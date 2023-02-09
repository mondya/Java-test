package test

import java.security.MessageDigest

class PadDecode {
    private static final String ENCODE_TEXT = "1231wjbjhb&&#*#*"

    //16进制下数字到字符的映射数组
    private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    

    static void main(String[] args) {
//        String mac = '54:ef:33:6a:d8:62'
        String mac = '8C:FC:A0:23:9E:C2'
        String no = '7L03357PAJDDAAD'

        String decode = no + ENCODE_TEXT + mac
        
        String encode = encodeByMD5(decode)

        println encode
        println encode.equals('66669900CC1188BB66EEDDDD4499FF33')
    }

    //对字符串进行MD5编码
    public static String encodeByMD5(String originstr) {
        if (originstr != null) {
            try {
                //创建具有指定算法名称的信息摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                //使用指定的字节数组对摘要进行最后的更新，然后完成摘要计算
                byte[] results = md.digest(originstr.getBytes());
                //将得到的字节数组编程字符窜返回
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    //转换字节数组为十六进制字符串
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultsb = new StringBuffer();
        for (byte value : b) {
            resultsb.append(byteToHexString(value));
        }
        return resultsb.toString();
    }

    //将字节转化成十六进制的字符串
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n / 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
