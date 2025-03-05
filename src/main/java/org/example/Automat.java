package org.example;
import java.io.*;
public class Automat {
    String[][] pravidla;
    int pocet;
    String[] konecna;
    Automat(String soubor) throws IOException{
        FileInputStream pom = new FileInputStream(soubor);
        InputStreamReader proud = new InputStreamReader(pom, "UTF-8");
        BufferedReader zdroj = new BufferedReader(proud);

        String radka;

        radka = zdroj.readLine();
        pocet = Integer.valueOf(radka).intValue();
        pravidla = new String[pocet][3];

        radka = zdroj.readLine();
        konecna = radka.split(" ");

        int i = 0;
        while((radka = zdroj.readLine()) != null){
            String[] slova = radka.split(" ");
            for(int j = 0; j < 3; j++){
                pravidla[i][j] = slova[j];
            }
            i++;
        }
    }
    boolean test(String text) {
        String stav = "S";
        int pozice = 0;
        char znak;
        String znakString;

        navesti:
        while (pozice < text.length()) {
            znak = text.charAt(pozice);
            znakString = String.valueOf(znak);
            pozice++;
            for (int i = 0; i < pocet; i++) {
                if (stav.equals(pravidla[i][0]) && znakString.matches(pravidla[i][1])) {
                    System.out.println(pravidla[i][1]);
                    System.out.println("ze stavu: " + pravidla[i][0]);
                    System.out.println("do stavu: " + pravidla[i][2]);
                    System.out.println("-----------------");
                    stav = pravidla[i][2];
                    continue navesti;
                }
            }
            return false;
        }
        System.out.println("stav " + stav + " pozice " + pozice);
        if (pozice != text.length()) return false;
        for (int i = 0; i < konecna.length; i++) {
            return stav.equals(konecna[i]);
        }
        return false;
    }
}
