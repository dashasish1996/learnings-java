package com.java.streams.utils;

import com.java.streams.model.Person;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class GeneratePersonData {
    public static List<Person> getPeople() {
        return Arrays.asList(
                new Person("Alice", 28, "Mumbai", 50000),
                new Person("Bob", 35, "Delhi", 70000),
                new Person("Charlie", 22, "Bangalore", 40000),
                new Person("David", 45, "Mumbai", 90000),
                new Person("Eve", 30, "Bangalore", 60000),
                new Person("Frank", 38, "Delhi", 75000),
                new Person("Grace", 29, "Kolkata", 45000),
                new Person("Heidi", 50, "Delhi", 120000),
                new Person("Ivan", 41, "Bangalore", 80000),
                new Person("Judy", 33, "Mumbai", 67000)
        );
    }
}
