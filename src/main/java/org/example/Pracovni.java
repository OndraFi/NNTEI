package org.example;

import java.util.regex.*;

public class Pracovni {
    static boolean vyhovuje(String text, String rv) {
        Pattern p = Pattern.compile(rv);
        Matcher m = p.matcher(text);
        return m.matches();
    }

    static void obsahuje(String text, String rv) {
        Pattern p = Pattern.compile(rv);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    static void vypisVzor(String text, String rv) {
        Pattern p = Pattern.compile(rv);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println("Nalezeno: " + m.group());
        }
    }

    static String nahradDatumy(String text) {
        String rv = "(\\d{1,2})[.](\\d{1,2})[.](\\d{4})";
        String pom = text.replaceAll(rv, "$2/$1/$3");

        String rv2 = "(\\d{1})[/](\\d{1,2})[/](\\d{4})";
        String mesicOk = pom.replaceAll(rv2, "0$1/$2/$3");

        String checkDen = "(\\d{2})[/](\\d{1})[/](\\d{4})";
        String denOk = mesicOk.replaceAll(checkDen,"$1/0$2/$3");

        String changeRok = "(\\d{2})[/](\\d{2})[/](\\d{2})(\\d{2})";
        return denOk.replaceAll(changeRok,"$1/$2/$4");
    }
}
