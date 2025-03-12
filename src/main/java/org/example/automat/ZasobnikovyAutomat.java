package org.example.automat;

public class ZasobnikovyAutomat {
    static boolean jeNeterminal(char znak) {
        return znak == 'Z';
    }

    static String p(char text, int pravidlo) {
        if (jeNeterminal(text)) {
            if (pravidlo == 1) return "";
            if (pravidlo == 2) return "(Z)";
            if (pravidlo == 3) return "[Z]";
        }
        ;
        return "CHYBA";
    }

    public static void testZavorek() {
        Zasobnik<Character> z = new Zasobnik<>();
        char znak;
        String text = "([])";
        int[] pravidla = {2, 3, 1};
        int pravidlo = 0, pozice = 0;

    }

}
