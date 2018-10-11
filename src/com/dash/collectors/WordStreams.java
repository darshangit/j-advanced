package com.dash.collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordStreams {

    public static void main(String[] args) throws IOException {

        Path shakespearePath = Paths.get("D:\\dev\\java-advanced-8\\src\\com\\dash\\streams\\words_01.txt");
        Path ospdPath = Paths.get("D:\\dev\\java-advanced-8\\src\\com\\dash\\streams\\words_02.txt");

        try(Stream<String> ospd = Files.lines(ospdPath);
            Stream<String> shakespeare = Files.lines(shakespearePath);) {
            Set<String> scrabbleWords = ospd.collect(Collectors.toSet());
            Set<String> shakespeareWords = shakespeare.collect(Collectors.toSet());

            System.out.println("Scrabble words : " + scrabbleWords.size());
            System.out.println("Shakespeare : " + shakespeareWords.size());



            final int[] scrabbleEnScore = {
                    1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10
            };

            Function<String, Integer> score = word -> word.toLowerCase().chars().map(letter -> scrabbleEnScore[letter - 'a']).sum();

            Map<Integer, List<String>> historyWordsByScore = shakespeareWords.stream().filter( scrabbleWords::contains).collect(
                    Collectors.groupingBy(score)
            );

            System.out.println(" # history words by size : "+ historyWordsByScore);

            historyWordsByScore.entrySet().stream().sorted(Comparator.comparing(integerListEntry -> -integerListEntry.getKey())).limit(3).forEach(integerListEntry -> System.out.println(integerListEntry.getKey() + "-" + integerListEntry.getValue()));

            Function<String, Map<Integer, Long>> histoWord = word -> word.chars().boxed().collect(Collectors.groupingBy(letter -> letter, Collectors.counting()));

        }

    }
}
