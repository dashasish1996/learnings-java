package com.examples.design.patterns.Factory.models;

public class CircleArea implements Area{
    @Override
    public void printAreaFormula() {
        System.out.println("[CircleArea] = pi * r^2");
    }
}
