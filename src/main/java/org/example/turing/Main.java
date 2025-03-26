package org.example.turing;

public class Main {
    public static void main(String[] args) {
        String s = "11111B111B";
        Turing t = new Turing(s,s.length());
        t.simulace();

    }
}
