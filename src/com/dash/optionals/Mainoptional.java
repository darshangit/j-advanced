package com.dash.optionals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mainoptional {

    public static void main(String[] args) {
        List<Double> result = new ArrayList<>();

//        ThreadLocalRandom.current().doubles(10_000).boxed()
//                .forEach(aDouble -> NewMath.inv(aDouble).ifPresent(inv -> NewMath.sqrt(inv).ifPresent(result::add)));
//
//        System.out.println("result :  " + result.size());

        Function<Double, Stream<Double>> flatMapper =
                d -> NewMath.inv(d).flatMap(NewMath::sqrt).
                map(Stream::of)
                .orElseGet(() -> Stream.empty());

        List<Double> rightResult = ThreadLocalRandom.current()
                .doubles(10_000)
                .parallel()
                .boxed()
                .flatMap(flatMapper)
                .collect(Collectors.toList());

        System.out.println(" rightResult : " + rightResult.size());
    }
}
