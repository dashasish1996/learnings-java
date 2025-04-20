package com.examples.design.patterns.Factory.models;

public class RectangleArea implements Area{
    @Override
    public void printAreaFormula() {
        System.out.println("[RectangleArea] = length * breadth");
    }
}
