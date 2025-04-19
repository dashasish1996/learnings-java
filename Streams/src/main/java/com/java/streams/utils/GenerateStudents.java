package com.java.streams.utils;

import com.java.streams.model.Student;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class GenerateStudents {
    public static  List<Student> students = List.of(
            new Student("Alice", "Johnson", "Miami", 9.1, 20, "Computer Science"),
            new Student("Bob", "Smith", "New York", 7.5, 22, "Mechanical"),
            new Student("Charlie", "Brown", "Miami", 8.3, 19, "Computer Science"),
            new Student("David", "Williams", "Los Angeles", 6.9, 21, "Electronics"),
            new Student("Eva", "Martinez", "Miami", 7.8, 23, "Mechanical"),
            new Student("Frank", "Anderson", "Chicago", 9.5, 24, "Computer Science"),
            new Student("Grace", "Taylor", "Houston", 8.0, 20, "Electronics"),
            new Student("Hannah", "Moore", "Miami", 8.9, 22, "Computer Science"),
            new Student("Ian", "Thomas", "Chicago", 9.7, 18, "Mechanical"),
            new Student("Julia", "Jackson", "New York", 7.2, 21, "Electronics")
    );

}
