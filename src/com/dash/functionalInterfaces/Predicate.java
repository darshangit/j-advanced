package com.dash.functionalInterfaces;

@FunctionalInterface
public interface Predicate<T> {

    public boolean test(T t);

    public default Predicate<T> and(Predicate<T> p2) {
        return t -> test(t) && p2.test(t);
    }
}
