package org.example;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String rv = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";

        String text = "asdf asdfff  peparak@gmail.com asdfffffffffffffffff kkkfkf bombastic@gmail.com kfk kfk ";

        if(Pracovni.vyhovuje(text, rv)){
            System.out.println("Vyhovuje");
        }else {
            System.out.println("Nevyhovuje");
        }

        Pracovni.obsahuje(text, rv);


    }
}