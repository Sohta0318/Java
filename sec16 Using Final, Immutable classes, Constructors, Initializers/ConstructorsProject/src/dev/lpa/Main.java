package dev.lpa;

import external.Child;

public class Main {
    public static void main(String[] args) {
        Parent parent = new Parent("Jane Doe", "01/01/1950", 4);
//        Parent parent2 = new Parent("Jane Doe", "01/01/1950", 4);

        Child child = new Child();

        System.out.println("parent = " + parent);
        System.out.println("child = " + child);

        Person joe = new Person("Joe", "01-01-1950");
        System.out.println(joe);

        Person joeCopy = new Person(joe);
        System.out.println(joeCopy);

        Generation g = Generation.BABY_BOOMER;
//        Generation h = new Generation.BABY_BOOMER(1900, 2011);


    }
}
