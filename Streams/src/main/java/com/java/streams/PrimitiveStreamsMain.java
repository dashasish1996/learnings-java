package com.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimitiveStreamsMain {



    public static void main(String[] args) {
        // Convert List of String to uppercase
        List<String> words = Arrays.asList("java", "stream", "api");
        words.stream().map(String::toUpperCase).forEach(System.out::println);

        //  Convert List to Map (index -> value)
        List<String> items = Arrays.asList("a", "b", "c");
        IntStream.range(0, items.size())
                .boxed()
                .collect(Collectors.toMap(i -> i, items::get))
                        .entrySet().forEach(System.out::println);

        // Sort List of Strings in Reverse Order
        words.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
