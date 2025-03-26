package org.example.ukol3;

import java.io.*;
import java.util.*;

public class Turing {
    static class Pravidlo {
        int stav;
        char vstup;
        char akce;
        int novyStav;

        Pravidlo(int stav, char vstup, char akce, int novyStav) {
            this.stav = stav;
            this.vstup = vstup;
            this.akce = akce;
            this.novyStav = novyStav;
        }
    }

    int max;
    char[] paska;
    int pozice;
    int stav;
    List<Pravidlo> pravidla;

    Turing(String retezec, int n, String soubor) throws IOException {
        pozice = 0;
        stav = 1;
        max = n;
        paska = new char[max];
        pravidla = new ArrayList<>();

        // Inicializace pásky
        Arrays.fill(paska, 'B');
        for (int i = 0; i < retezec.length(); i++) {
            paska[i] = retezec.charAt(i);
        }

        // Načtení pravidel ze souboru
        BufferedReader br = new BufferedReader(new FileReader(soubor));
        String radek;
        while ((radek = br.readLine()) != null) {
            String[] casti = radek.split("\\s+");
            int s = Integer.parseInt(casti[0]);
            char vstup = casti[1].charAt(0);
            char akce = casti[2].charAt(0);
            int novy = Integer.parseInt(casti[3]);
            pravidla.add(new Pravidlo(s, vstup, akce, novy));
        }
        br.close();
    }

    char cti() {
        return paska[pozice];
    }

    void zapis(char co) {
        paska[pozice] = co;
    }

    void simulace() {
        while (true) {
            boolean provedeno = false;
            for (Pravidlo p : pravidla) {
                if (p.stav == stav && p.vstup == cti()) {
                    if (p.akce == 'R') {
                        pozice++;
                    } else if (p.akce == 'L') {
                        pozice--;
                    } else {
                        zapis(p.akce);
                    }
                    stav = p.novyStav;
                    vypis();
                    provedeno = true;
                    break;
                }
            }
            if (!provedeno) break;
        }
    }

    void vypis() {
        for (int i = 0; i < pozice; i++)
            System.out.print(paska[i]);
        System.out.print("(q" + stav + ")");
        for (int i = pozice; i < max; i++)
            System.out.print(paska[i]);
        System.out.println();
    }
}
