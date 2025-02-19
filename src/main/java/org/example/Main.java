package org.example;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


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

        String content = null;
        URLConnection connection = null;
        try {
            connection =  new URL("https://www.upce.cz/").openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }
//        System.out.println(content);

        rv = "https:\\/\\/[a-zA-z0-9._\\-\\/\\?\\=\\&]*";

        Pracovni.vypisVzor(content, rv);

        // náhrada datumu

        String textDatum = "Dnes je 19.2.2025 a zítra bude 20.2.2025.";
        System.out.println(textDatum);
        String textDatumEn = Pracovni.nahradDatumy(textDatum);
        System.out.println(textDatumEn);




    }
}