package org.example;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(Jazyk.jeIdentifikator("Ahoj1"));
        System.out.println(Jazyk.jeCisloBezZnamenka("1234"));
        System.out.println(Jazyk.jeCeleCislo("+1234"));
        System.out.println(System.getProperty("user.dir"));
        Automat a = new Automat("automat2.txt");
        System.out.println(a.test("12.36"));
    }
}