package finalString;

// 字符串常量池的作用
public class TestFinalString {
    public static void main(String[] args) {
        String a = "ab";
        String b = "ab";
        
        System.out.println(a == b); // true

        // str放入常量池
        String str1 = "str";
        // ing放入常量池
        String str2 = "ing";
        // string放入常量池, str3引用指向常量池中string
        String str3 = "str" + "ing";
        // 引用指向str1 + str2
        String str4 = str1 + str2;
        // 引用直接指向常量池中string
        String str5 = "string";
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false

    }
}
