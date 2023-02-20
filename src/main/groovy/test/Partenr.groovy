package test

import java.util.regex.Matcher
import java.util.regex.Pattern

class Partenr {
    static void main(String[] args) {
        Pattern p = Pattern.compile("^1[3456789]\\d{9}\$");
        Matcher matcher = p.matcher("19906811051");
        boolean matches = matcher.matches();
        print(matches)

        Pattern p1 = Pattern.compile("^[\\u4e00-\\u9fa5A-Za-z0-9 _ \\- @ # ( ) （ ）]+\$")
        Matcher m = p1.matcher("test-")
        println m.matches()
    }
}
