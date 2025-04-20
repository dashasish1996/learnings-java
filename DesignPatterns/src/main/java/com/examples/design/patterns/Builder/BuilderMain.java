package com.examples.design.patterns.Builder;

public class BuilderMain {
    public static void main(String[] args) {
        User user1 = new User.UserBuilder("Alice", "alice@example.com")
                .age(25)
                .phoneNumber("123-456-7890")
                .build();

        User user2 = new User.UserBuilder("Bob", "bob@example.com")
                .address("New York")
                .build();

        System.out.println(user1.getName() + ", " + user1.getPhoneNumber());
        System.out.println(user2.getName() + ", " + user2.getAddress());
    }
}
