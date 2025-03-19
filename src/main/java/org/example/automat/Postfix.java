/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.automat;
/**
 *
 * @author jora0383
 */
public class Postfix {
    //je vstupni retezec operator?
    static private boolean jeOperator(String ret) {
        //vycet pripustnych operatoru
        String[] poleOperatoru = {"*", "/", "-", "+"};
        for (String string : poleOperatoru) {
            if (string.equals(ret)) {
                return true;
            }
        }
        return false;
    }

    static private double provedOperaci(double operand1, double operand2, String operator) {
        if (operator.equals("*")) {
            return operand1 * operand2;
        } else if (operator.equals("/")) {
            return operand1 / operand2;
        }
        if (operator.equals("+")) {
            return operand1 + operand2;
        }
        if (operator.equals("-")) {
            return operand1 - operand2;
        }
        throw new RuntimeException();
    }

    //postfixvyraz je ve formatu napr. "3 5 + 2 * 3 2 / -"
    public static void dejVysledekVyrazu(String postfixVyraz) {
        String[] polePrvku = postfixVyraz.split(" ");
        Zasobnik<Double> z = new Zasobnik<>();
        for (String string : polePrvku) {
            if (jeOperator(string)) {
                double operand2 = z.vyber();
                double operand1 = z.vyber();
                z.pridej(provedOperaci(operand1, operand2, string));
            } else {
                z.pridej(Double.parseDouble(string));
            }
        }
        System.out.println("Vásledek: " + z.vyber());
    }

}
