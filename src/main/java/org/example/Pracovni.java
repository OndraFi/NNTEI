package org.example;

import java.util.regex.*;

public class Pracovni {
    static boolean vyhovuje(String text, String rv){
        Pattern p = Pattern.compile(rv);
        Matcher m = p.matcher(text);
        return m.matches();
    }

    static void obsahuje(String text, String rv){
        Pattern p = Pattern.compile(rv);
        Matcher m = p.matcher(text);
        while(m.find()){
            System.out.println(m.group());
        }
    }
    static void vypisVzor(String text, String rv){
        Pattern p = Pattern.compile(rv);
        Matcher m = p.matcher(text);
        while(m.find()){
            System.out.println("Nalezeno: "+m.group());
        }
    }
}
