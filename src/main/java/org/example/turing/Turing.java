package org.example.turing;

public class Turing {
    int max;
    char[] paska;
    int pozice;
    int stav;
    Turing(String retezec,int n){
        pozice = 0;
        stav = 1;
        max = n;
        paska = new char[max];
        for(int i=0;i<max;i++)
            paska[i]='B';
        for(int i=0;i<retezec.length();i++)
            paska[i] = retezec.charAt(i);
    }
    char cti(){
        return paska[pozice];
    }
    void zapis(char co){
        paska[pozice]=co;
    }
    void simulace(){
        while(true){
            if (stav==1&&cti()=='1'){
                zapis('B');
                stav = 1;
                vypis();
                continue;
            }
            if (stav==1&&cti()=='B'){
                pozice++;
                stav = 2;
                vypis();
                continue;
            }
            if (stav==2&&cti()=='1'){
                pozice++;
                stav = 2;
                vypis();
                continue;
            }
            if (stav==2&&cti()=='B'){
                pozice++;
                stav = 3;
                vypis();
                continue;
            }
            if (stav==3&&cti()=='1'){
                zapis('B');
                stav = 3;
                vypis();
                continue;
            }
            break;
        }
    }
    void vypis(){
        for(int i=0;i<pozice;i++)
            System.out.print(paska[i]);
        System.out.print("(q"+stav+")");
        for(int i=pozice;i<max;i++)
            System.out.print(paska[i]);
        System.out.println();
    }
}
