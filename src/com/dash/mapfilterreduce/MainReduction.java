package com.dash.mapfilterreduce;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class MainReduction {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

        List<Integer> ints1 = Arrays.asList(0,1,2,3,4);
        List<Integer> ints2 = Arrays.asList(5,6,7,8,9);

        BinaryOperator<Integer> op = (integer, integer2) -> integer + integer2;
//      BinaryOperator<Integer> op = (integer, integer2) -> (integer + integer2)/2; // Non associative

        int returnVal = reduce(ints,0,op);

        System.out.println("Reduction result" + returnVal);

    }

    public static int reduce(List<Integer> values, int valueIfEmpty, BinaryOperator<Integer> reduction){
        int result = valueIfEmpty;

        for(int value: values) {
            result = reduction.apply(result, value);
        }

        return result;
    }
}
