package org.example.ukol3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String s = "11111B111B";
        Turing t = null;
        try {
            t = new Turing(s,s.length(),"./odecitani.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        t.simulace();

    }
}
