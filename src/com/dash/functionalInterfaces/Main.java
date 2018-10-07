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

        Predicate<String> p4 = p1.or(p2);

        System.out.println("p4 predicate or: " + p4.test("DASHasdasda"));

        Predicate<String> p5 = Predicate.isEqualTo("Yes");

        System.out.println("p5 yes: "+ p5.test("Yes"));
        System.out.println("p5 No: "+ p5.test("No"));

        Predicate<Integer> p6 = Predicate.isEqualTo(1);
        System.out.println("p=6 Yes: "+ p6.test(1));



    }
}
