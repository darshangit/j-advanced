package com.dash.spliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CreatingSpliterator {

    public static void main(String[] args) {

        Path path = Paths.get("D:\\dev\\java-advanced-8\\src\\com\\dash\\spliterator\\people.txt");

        try (Stream<String> lines = Files.lines(path)){

            Spliterator<String> lineSpliterator =  lines.spliterator();
            Spliterator<Person> peopleSpilterator =  new PersonSpliterator(lineSpliterator);

            Stream<Person> people = StreamSupport.stream(peopleSpilterator, false);
            people.forEach(System.out::println);


        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
