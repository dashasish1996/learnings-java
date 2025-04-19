package com.java.streams.model;

public class Person {
    private String name;
    private int age;
    private String city;
    private double salary;

    // Constructors
    public Person(String name, int age, String city, double salary) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.salary = salary;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }
    public double getSalary() { return salary; }

    // toString
    @Override
    public String toString() {
        return name + " - " + age + " - " + city + " - " + salary;
    }
}
