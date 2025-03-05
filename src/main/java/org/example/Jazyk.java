package org.example;

public class Jazyk {
    static char ctiZnak(String retezec, int pozice){
        return retezec.charAt(pozice);
    }
    static boolean jeIdentifikator(String retezec){
        if (!Character.isLetter(ctiZnak(retezec,0)))
            return false;
        for(int i=1;i<retezec.length();i++){
            char znak = ctiZnak(retezec,i);
            if (!Character.isLetter(znak) && !Character.isDigit(znak))
                return false;
        }
        return true;
    }
    static boolean jeCisloBezZnamenka(String retezec){
        for(int i=0;i<retezec.length();i++){
            char znak = ctiZnak(retezec,i);
            if (!Character.isDigit(znak))
                return false;
        }
        return true;
    }
    static boolean jeCeleCislo(String retezec){
        if (Character.isDigit(ctiZnak(retezec,0)))
            return jeCisloBezZnamenka(retezec);
        if (ctiZnak(retezec,0)=='+' || ctiZnak(retezec,0)=='-')
            return jeCisloBezZnamenka(retezec.substring(1));
        return false;
    }
}
