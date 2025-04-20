package com.examples.design.patterns.Builder;


public class User {
    // required
    private final String name;
    private final String email;

    // optional
    private final int age;
    private final String phoneNumber;
    private final String address;

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }


    public static class UserBuilder {
        private final String name;
        private final String email;
        private int age;
        private String phoneNumber;
        private String address;

        public UserBuilder(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
