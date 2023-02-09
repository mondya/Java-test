package test

import java.util.regex.Matcher
import java.util.regex.Pattern

class Partenr {
    static void main(String[] args) {
        Pattern p = Pattern.compile("^1[3456789]\\d{9}\$");
        Matcher matcher = p.matcher("19906811051");
        boolean matches = matcher.matches();
        print(matches)
    }
}
