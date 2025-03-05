package org.example.automat;

public class Zasobnik<T> {
    Node vrchol;

    private class Node{
        T data;
        Node dalsi;

        Node(T data, Node dalsi){
            data = data;
            dalsi = dalsi;
        }
    }

    Zasobnik() {
        vrchol = null;
    }

    boolean jePrazdny(){
        return true;
    }

    void pridej(T prvek){
        if(vrchol == null){
            vrchol = new Node(prvek, null);
        }else{
            Node n = new Node(prvek, vrchol);
            vrchol = n;
        }
    }
    T vyber(){
        Node v = vrchol;
        Node predchozi = vrchol.dalsi;
        if(predchozi != null){
            vrchol = predchozi;
        }
        return vrchol.data;
    }

}
