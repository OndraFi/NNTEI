package org.example.ukol1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Ukol1 ukol = new Ukol1("./input.html","output.html","output.css");
        try {
            ukol.cleanHtml();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
