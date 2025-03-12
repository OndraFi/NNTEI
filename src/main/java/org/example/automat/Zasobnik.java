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

    public boolean jePrazdny() {
        return vrchol == null;
    }

    public void pridej(T prvek) {
        if (vrchol == null) {
            vrchol = new Node(prvek, null);
        } else {
            vrchol = new Node(prvek, vrchol);
        }
    }

    public T vyber() {
        Node v = vrchol;
        vrchol = vrchol.dalsi;
        return v.data;
    }

}
