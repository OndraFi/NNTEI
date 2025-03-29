package org.example.ukol2;

import java.util.Stack;

public class Ukol2 {

    static boolean jeNeterminal(char znak) {
        return znak == 'Z';
    }

    // Pravidla přepisů pro Z
    static String p(char znak, int pravidlo) {
        if (jeNeterminal(znak)) {
            switch (pravidlo) {
                case 0: return "{Z}";
                case 1: return "";
                case 2: return "(Z)";
                case 3: return "[Z]";
            }
        }
        return "CHYBA";
    }

    public static boolean otestujRetezec(String retezec, int[] pravidla) {
        Stack<Character> zasobnik = new Stack<>();
        zasobnik.push('Z');
        int pozice = 0;
        int indexPravidla = 0;

        while (!zasobnik.isEmpty()) {
            char vrchol = zasobnik.pop();

            if (jeNeterminal(vrchol)) {
                if (indexPravidla >= pravidla.length) {
                    System.out.println("Nedostatek pravidel!");
                    return false;
                }

                int pravidlo = pravidla[indexPravidla++];
                String nahrada = p(vrchol, pravidlo);

                if (nahrada.equals("CHYBA")) {
                    System.out.println("Neplatné pravidlo.");
                    return false;
                }

                // Přidej náhradu do zásobníku (pozpátku)
                for (int i = nahrada.length() - 1; i >= 0; i--) {
                    zasobnik.push(nahrada.charAt(i));
                }

            } else {
                // Porovnání terminálového znaku s řetězcem
                if (pozice >= retezec.length() || vrchol != retezec.charAt(pozice)) {
                    System.out.println("Chyba na pozici " + pozice + ": očekáván '" + vrchol + "', ale je '" + (pozice < retezec.length() ? retezec.charAt(pozice) : "konec") + "'");
                    return false;
                } else {
                    pozice++;
                }
            }
        }

        // Úspěšné přijetí jen pokud jsme na konci řetězce i pravidel
        return pozice == retezec.length() && indexPravidla == pravidla.length;
    }

    public static void main(String[] args) {
        String retezec = "{([])}";
        int[] pravidla = {0, 2, 3, 1};

        boolean vysledek = otestujRetezec(retezec, pravidla);

        System.out.println("Vysledek: " + (vysledek ? "Retezec lze vygenerovat!" : "Retezec nelze vygenerovat."));
    }
}
