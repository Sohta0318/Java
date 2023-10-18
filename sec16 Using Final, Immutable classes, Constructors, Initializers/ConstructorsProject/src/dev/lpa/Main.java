package dev.lpa;

import dev.external.Child;

public class Main {
    public static void main(String[] args) {
        Parent parent = new Parent("Jane Doe", "01/01/1950", 4);
        Child child = new Child();

        System.out.println("parent = " + parent);
        System.out.println("child = " + child);


    }
}
