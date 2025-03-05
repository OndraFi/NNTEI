package automat;
import java.io.*;
public class Automat {
    public String[][] pravidla;
    int pocet;
    String[] konecna;
    public Automat(String soubor) throws IOException{
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
    boolean test(String text){
        String stav = "S";
        int pozice = 0;
        char znak;
        String znakString;        
    }
}
