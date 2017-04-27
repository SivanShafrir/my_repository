package com.company;

public class Main {

    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.print();
    }


}
class Outer {
    class Inner {
        public void print() {
            System.out.println("Inner: print");
        }
    }
}
