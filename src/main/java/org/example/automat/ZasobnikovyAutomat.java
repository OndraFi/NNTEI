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
        return "CHYBA";
    }

    public static void testZavorek() {
        Zasobnik<Character> z = new Zasobnik<>();
        char znak;
        String text = "([])";
        String stav;
        int[] pravidla = {2, 3, 1};
        int pravidlo = 0, pozice = 0;
        z.pridej('Z');
        while (!z.jePrazdny()){
            znak = z.vyber();
            if(jeNeterminal(znak)){
                stav = p(znak,pravidla[pravidlo]);
                System.out.println("Pravidlo: " + pravidlo);
                pravidlo++;
                System.out.println("Novy stav: " + stav);
                for(int i = stav.length()-1; i >= 0; i--){
                    z.pridej(stav.charAt(i));
                }
            }else{
                if(text.charAt(pozice) == znak){
                    System.out.println("Prijato: " + znak);
                    pozice++;
                }else{
                    System.out.println("Spatny retezec");
                }
            }
        }
    }

}
