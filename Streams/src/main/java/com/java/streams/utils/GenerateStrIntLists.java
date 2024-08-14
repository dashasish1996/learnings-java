package com.java.streams.utils;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class GenerateStrIntLists {
    public static List<Integer> getIntegerList() {
        return List.of(1, -2, 0, 7, 13, -5, 1000, 400, 395, 783, 30, 45, 49, 83, 99, 0, 99, 1000, 999, 99, 83,1000);
    }

    public static List<String> getStringList() {
        return List.of("Java", "Python", "JavaScript", "Go", "TypeScript", "Ruby", "SpringBoot", "Angular", "React", "Happy", "Sad", "Working", "Learning", "Music", "Art");
    }
}
