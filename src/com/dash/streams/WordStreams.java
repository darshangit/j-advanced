package com.dash.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class WordStreams {

    public static void main(String[] args) throws IOException {
        Set<String> shakespeareWords = Files.lines(Paths.get("D:\\dev\\java-advanced-8\\src\\com\\dash\\streams\\words_01.txt"))
                .map(s -> s.toLowerCase()).collect(Collectors.toSet());

        Set<String> scarbbleWords = Files.lines(Paths.get("D:\\dev\\java-advanced-8\\src\\com\\dash\\streams\\words_02.txt"))
                .map(s->s.toLowerCase()).collect(Collectors.toSet());

        System.out.println("Count shakespeacre : "+ shakespeareWords.size());
        System.out.println("Count Scrablle : "+ scarbbleWords.size());

        final int[] scrabbleEnScore = {
                1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10
        };

        Function<String, Integer> score = word -> word.chars().map(letter -> scrabbleEnScore[letter - 'a']).sum();

        ToIntFunction<String> intScore = word -> word.chars().map(letter -> scrabbleEnScore[letter - 'a']).sum();

        System.out.println("Score of hello" + intScore.applyAsInt("hello"));

        String word = shakespeareWords.stream().filter(w -> scarbbleWords.contains(w)).max(Comparator.comparing(score))
                .get();

        System.out.println("Beast Word: " + word);

        IntSummaryStatistics intSummaryStatistics = shakespeareWords.stream().filter(scarbbleWords::contains).mapToInt(intScore).summaryStatistics();

        System.out.println("Statistics : "+ intSummaryStatistics);
    }
}
