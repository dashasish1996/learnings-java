package com.java.streams;

import com.java.streams.model.Person;
import com.java.streams.model.Student;
import com.java.streams.utils.GeneratePersonData;
import com.java.streams.utils.GenerateStudents;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        printStudentQuestionAnswers();
        printPersonQuestionAnswers();
    }



    private static void printStudentQuestionAnswers() {

        var students = GenerateStudents.students;
//        find all the students from miami with a grade > 8.0
        var a1 = students.stream().filter(s -> s.getCity().equalsIgnoreCase("miami") && s.getGrade()>8).toList();
        printList(a1, false);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
//        find the student with the highest grade
        var s1_a = students.stream().max(Comparator.comparing(Student::getGrade)).orElse(null);
        System.out.println(s1_a);
        var s1_b = students.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).findFirst().get();
        System.out.println(s1_b);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
//        count the number of students in each department
        var m3 = students.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        m3.entrySet().forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
//        find the avg grade per department
        var m4 = students.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.averagingDouble(Student::getGrade)));
        m4.entrySet().forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
//        sort students by age then by grade
        var a5 = students.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getGrade)).toList();
        printList(a5, false);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
//        get comma separated list of student names
        var a6 = students.stream().map(s -> s.getFirstName().concat(" ").concat(s.getLastName())).collect(Collectors.joining(","));
        System.out.println(a6);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
//        check if all students are above 18
        var a7 = students.stream().allMatch(s -> s.getAge() > 18);
        System.out.println(a7);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
//        find the department with most students
        var a8 = students.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
        System.out.println(a8);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
//        partition students into grades > 8.0 and <= 8.0
        var a9 = students.stream().collect(Collectors.partitioningBy(s -> s.getGrade() > 8));
        a9.entrySet().forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
//        find the student with the longest full name
        var a10 = students.stream().map(s -> s.getFirstName().concat(" ").concat(s.getLastName())).max(Comparator.comparing(String::length)).orElse(null);
        System.out.println(a10);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
    }


    private static void printPersonQuestionAnswers() {
        var people = GeneratePersonData.getPeople();

        // [Easy] Example1 : Filter all people older than 30
        System.out.println("[Easy] Example1 : Filter all people older than 30");
        people.stream()
                .filter(p -> p.getAge() < 30)
                .forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Easy] Example2 : Get a list of all names
        System.out.println("[Easy] Example2 : Get a list of all names");
        var namesImmutable = people.stream()
                .map(Person::getName)
                .toList();
        printList(namesImmutable, true);
        var namesMutable = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        printList(namesMutable, true);

        checkMutability("Mutable List", namesMutable);
        checkMutability("Immutable List", namesImmutable);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Easy] Example3 : Sort the people by age ascending
        System.out.println("[Easy] Example3 : Sort the people by age ascending");
        people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Easy] Example4 : Find the person with the highest salary
        System.out.println("[Easy] Example4 : Find the person with the highest salary");
        System.out.println(people.stream()
                .max(Comparator.comparingDouble(Person::getSalary))
                .orElse(null));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Easy] Example5 : Get the count of people from Mumbai
        System.out.println("[Easy] Example5 : Get the count of people from Mumbai");
        System.out.println(people.stream().filter(p -> p.getCity().equalsIgnoreCase("Mumbai")).count());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Easy] Example6 : Check if all people are older than 18
        System.out.println("[Easy] Example6 : Check if all people are older than 18");
        System.out.println("All Adults? - " + people.stream().allMatch(p -> p.getAge() > 18));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Intermediate] Example7 : Group all people by city
        System.out.println("[Intermediate] Example7 : Group all people by city");
        var gpExample7 = people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.mapping(Person::getName, Collectors.toList())));
        gpExample7.entrySet().forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Intermediate] Example8 : Find average salary of people in each city
        System.out.println("[Intermediate] Example8 : Find average salary of people in each city");
        var gpExample8 = people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.averagingDouble(Person::getSalary)));
        gpExample8.entrySet().forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Intermediate] Example9 : Partition people based on salary > 50,000
        System.out.println("[Intermediate] Example9 : Partition people based on salary > 50,000");
        var gpExample9 = people.stream().collect(Collectors.partitioningBy(p -> p.getSalary()>50000, Collectors.mapping(Person::getName, Collectors.toList())));
        gpExample9.entrySet().forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");


        // [Intermediate] Example10 : Get names of top 3 earners sorted by salary
        System.out.println("[Intermediate] Example10 : Get names of top 3 earners sorted by salary");
        var listExample10 = people.stream().sorted(Comparator.comparingDouble(Person::getSalary).reversed()).limit(3).map(Person::getName).toList();
        printList(listExample10, true);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Intermediate] Example11 : Group people by age and list their names
        System.out.println("[Intermediate] Example11 : Group people by age and list their names");
        var gpExample11 = people.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName, Collectors.toList())));
        gpExample11.entrySet().forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Intermediate] Example12 : Get a comma-separated string of names who live in Bangalore
        System.out.println("[Intermediate] Example12 : Get a comma-separated string of names who live in Bangalore");
        String resExample12 = people.stream().filter(p -> p.getCity().equalsIgnoreCase("Bangalore")).map(Person::getName).collect(Collectors.joining(","));
        System.out.println(resExample12);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Intermediate] Example13 : Sort people by name, then by salary
        System.out.println("[Intermediate] Example13 : Sort people by name, then by salary");
        var listExample13 = people.stream().sorted(Comparator.comparing(Person::getName).thenComparing(Person::getSalary)).collect(Collectors.toList());
        printList(listExample13, false);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Advanced] Example14 : Find the highest earner in each city
        System.out.println("[Advanced] Example14 : Find the highest earner in each city");
        var gpExample14 = people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.maxBy(Comparator.comparing(Person::getSalary))));
        var gpExample14Names = gpExample14.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().get().getName()));
        gpExample14.entrySet().forEach(System.out::println);
        gpExample14Names.entrySet().forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Advanced] Example15 : Get salary statistics for each city
        System.out.println("[Advanced] Example15 : Get salary statistics for each city");
        var gpExample15 = people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.summarizingDouble(Person::getSalary)));
        gpExample15.entrySet().forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Advanced] Example16 : Sort people by city and within city by descending salary
        System.out.println("[Advanced] Example16 : Sort people by city and within city by descending salary");
        var listExample16a = people.stream().sorted(
                Comparator.comparing(Person::getCity).thenComparing(Person::getSalary)).toList();
        printList(listExample16a, false);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        var listExample16b = people.stream().sorted(
                Comparator.comparing(Person::getCity).reversed().thenComparing(Person::getSalary)).toList();
        printList(listExample16b, false);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        var listExample16c = people.stream().sorted(
                Comparator.comparing(Person::getCity).thenComparing(Person::getSalary).reversed()).toList();
        printList(listExample16c, false);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        var listExample16d = people.stream().sorted(
                Comparator.comparing(Person::getCity).reversed().thenComparing(Person::getSalary).reversed()).toList();
        printList(listExample16d, false);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");


        // [Advanced] Example17 : Flatten a list of people's names split by characters into a single character list
        System.out.println("[Advanced] Example17 : Flatten a list of people's names split by characters into a single character list");
        var listExample17 = people.stream().map(Person::getName).flatMap(n -> Arrays.stream(n.split(""))).toList();
        printList(listExample17, true);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Advanced] Example18 :  Group people by city and collect top 2 earners in each city
        System.out.println("[Advanced] Example18 :  Group people by city and collect top 2 earners in each city");
        var gpExample18 = people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.collectingAndThen(
                Collectors.toList(),
                list -> list.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).limit(2).collect(Collectors.toList())
        )));
        gpExample18.entrySet().forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // [Advanced] Example19 : Create a Map<String, Double> with city name as key and total
        System.out.println("[Advanced] Example19 : Create a Map<String, Double> with city name as key and total");
        var gpExample19 = people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.summingDouble(Person::getSalary)));
        gpExample19.entrySet().forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
    }


    public static <T> void printList(List<T> list, boolean commaSeparated) {
        if (commaSeparated) {
            System.out.println(
                    list.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(", "))
            );
        } else {
            for (T item : list) {
                System.out.println(item);
            }
        }
    }

    public static <T> void checkMutability(String label, List<T> list) {
        System.out.println("Checking: " + label);
        try {
            list.add(null);
            System.out.println("✅ " + label + " is mutable.");
        } catch (UnsupportedOperationException e) {
            System.out.println("❌ " + label + " is immutable.");
        }
    }

}
