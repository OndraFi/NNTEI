package org.example;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import org.example.automat.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        String rv = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
//
//        String text = "asdf asdfff  peparak@gmail.com asdfffffffffffffffff kkkfkf bombastic@gmail.com kfk kfk ";
//
//        if(Pracovni.vyhovuje(text, rv)){
//            System.out.println("Vyhovuje");
//        }else {
//            System.out.println("Nevyhovuje");
//        }
//
//        Pracovni.obsahuje(text, rv);
//
//        String content = null;
//        URLConnection connection = null;
//        try {
//            connection =  new URL("https://www.upce.cz/").openConnection();
//            Scanner scanner = new Scanner(connection.getInputStream());
//            scanner.useDelimiter("\\Z");
//            content = scanner.next();
//            scanner.close();
//        }catch ( Exception ex ) {
//            ex.printStackTrace();
//        }
////        System.out.println(content);
//
//        rv = "https:\\/\\/[a-zA-z0-9._\\-\\/\\?\\=\\&]*";
//
//        Pracovni.vypisVzor(content, rv);

        // náhrada datumu

        // datumy
//        String textDatum = "Dnes je 19.2.2025 a zítra bude 20.2.2025.";
//        System.out.println(textDatum);
//        String textDatumEn = Pracovni.nahradDatumy(textDatum);
//        System.out.println(textDatumEn);

        // automat
//        System.out.println(Jazyk.jeIdentifikator("Ahoj1"));
//        System.out.println(Jazyk.jeCisloBezZnamenka("1234"));
//        System.out.println(Jazyk.jeCeleCislo("+1234"));
//        System.out.println(System.getProperty("user.dir"));
//        Automat a = new Automat("automat5.txt");
//        System.out.println(a.test("id<=12.5"));


        Zasobnik<Integer> z = new Zasobnik<>();
        z.pridej(1);
        z.pridej(2);
        z.pridej(3);
        System.out.println(z.vyber());
        System.out.println(z.vyber());
        System.out.println(z.vyber());

        Zasobnik<String> z1 = new Zasobnik<>();
        z1.pridej("Ahoj");
        z1.pridej("Svete");
        System.out.println(z1.vyber());
        System.out.println(z1.vyber());


    }
}