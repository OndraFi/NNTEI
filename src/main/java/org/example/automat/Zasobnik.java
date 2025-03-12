package org.example.automat;

public class Zasobnik<T> {
    Node vrchol;

    private class Node {
        T data;
        Node dalsi;

        Node(T data, Node dalsi) {
            this.data = data;
            this.dalsi = dalsi;
        }


    }

    public Zasobnik() {
        vrchol = null;
    }

    public boolean jePrazdny() {
        if (vrchol == null) {
            return false;
        }
        return true;
    }

    public void pridej(T prvek) {
        if (vrchol == null) {
            vrchol = new Node(prvek, null);
        } else {
            Node n = new Node(prvek, vrchol);
            vrchol = n;
        }
    }

    public T vyber() {
        Node v = vrchol;
        Node predchozi = vrchol.dalsi;
        if (predchozi != null) {
            vrchol = predchozi;
        } else vrchol = null;
        return v.data;
    }

}
