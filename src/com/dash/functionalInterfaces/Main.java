package com.dash.functionalInterfaces;

public class Main {
    public static void main(String[] args) {

        Predicate<String> p1 = s -> s.length() < 20;
        Predicate<String> p2 = s -> s.length() > 5 ;


        boolean b = p1.test("hello");

        System.out.println(b);

        Predicate<String> p3 = p1.and(p2);

        System.out.println("p3 predicate: " + p3.test("AWesome"));
        System.out.println("p3 predicate: " + p3.test("AWE"));

    }
}
