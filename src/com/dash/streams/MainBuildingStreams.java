package com.dash.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainBuildingStreams {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(0,1,2,3,4);
        // One way of building streams
        Stream<Integer> stream1 = ints.stream();

        // 2nd way of building streams
        Stream<Integer> stream = Stream.of(0,1,2,3,4);

        //3rd way of building stream
        Stream<String> streamOfStrings = Stream.generate(() -> "one");

        //4th way of building stream
        Stream<String> streamOfStrings2 = Stream.iterate("+", s -> s + "+");

        IntStream streamOfInt = ThreadLocalRandom.current().ints();

        streamOfInt.limit(5).forEach(System.out::println);

        stream.filter(integer -> integer > 2).forEach(System.out::println);

    }
}
