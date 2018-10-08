package com.dash.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class AdvancedStream {

    public static void main(String[] args) throws IOException {

        Stream<String> stream1 = Files.lines(Paths.get("D:\\dev\\java-advanced-8\\src\\com\\dash\\streams\\SampleText_01.txt"));
        Stream<String> stream2 = Files.lines(Paths.get("D:\\dev\\java-advanced-8\\src\\com\\dash\\streams\\SampleText_02.txt"));
        Stream<String> stream3= Files.lines(Paths.get("D:\\dev\\java-advanced-8\\src\\com\\dash\\streams\\SampleText_03.txt"));

//        System.out.println("Stream 1 : "+ stream1.count());
//        System.out.println("Stream 2 : "+ stream2.count());
//        System.out.println("Stream 3 : "+ stream3.count());

        Stream<Stream<String>> streamOfStreams = Stream.of(stream1, stream2, stream3);
//        System.out.println("Count total : " + streamOfStreams.count());

        Stream<String> streamOfLines = streamOfStreams.flatMap(Function.identity());
//        System.out.println("Count total : " + streamOfLines.count());

        Function<String, Stream<String>> lineSplitter = line -> Pattern.compile(" ").splitAsStream(line);

        //distinct words count
        Stream<String> streamOfWords = streamOfLines.flatMap(lineSplitter)
                .map(word -> word.toLowerCase()).distinct();

        System.out.println("WordsL " + streamOfWords.count());
    }
}
