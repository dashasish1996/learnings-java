package com.java.streams.model;

public class Student {
    private String firstName;
    private String lastName;
    private String city;
    private double grade;
    private int age;
    private String department;

    public Student(String firstName, String lastName, String city,
                   double grade, int age, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.grade = grade;
        this.age = age;
        this.department = department;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCity() { return city; }
    public double getGrade() { return grade; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }

    // Setters (optional, only if mutability is needed)
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setCity(String city) { this.city = city; }
    public void setGrade(double grade) { this.grade = grade; }
    public void setAge(int age) { this.age = age; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return String.format("%s %s (%s, %s, %.1f, %d)",
                firstName, lastName, city, department, grade, age);
    }
}
