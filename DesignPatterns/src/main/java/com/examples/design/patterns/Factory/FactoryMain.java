package com.examples.design.patterns.Factory;

import com.examples.design.patterns.Factory.abstract_factory.RectangleAreaFactory;
import com.examples.design.patterns.Factory.abstract_factory.ShapeAreaFactory;
import com.examples.design.patterns.Factory.factory_method.CircleFactory;
import com.examples.design.patterns.Factory.factory_method.ShapeFactory;
import com.examples.design.patterns.Factory.models.Area;
import com.examples.design.patterns.Factory.models.Shape;
import com.examples.design.patterns.Factory.simple_factory.SimpleShapeFactory;

public class FactoryMain {
    public static void main(String[] args) {
        // using SimpleFactory
        /*
         * A static method in one class returns different types of objects based on input.
         * Centralizes object creation logic but violates Open/Closed Principle if extended often.
         */
        Shape shapeCircle_1 = SimpleShapeFactory.getShape("circle");
        shapeCircle_1.draw();

        // Using FactoryMethod
        /*
         * Defines an interface for creating an object, but lets subclasses decide which class to instantiate.
         * Promotes polymorphism and Open/Closed Principle, making code extensible.
         */
        ShapeFactory factory = new CircleFactory();
        Shape shapeCircle_2 =  factory.createShape();
        shapeCircle_2.draw();

        // Using AbstractFactory to create family of Objects
        /*
         * Provides an interface to create families of related or dependent objects without specifying concrete classes.
         * Useful when products from multiple factories must work together (e.g., GUI kits for different OS).
         */
        ShapeAreaFactory shapeAreaFactory = new RectangleAreaFactory();
        Shape shapeCircle_3 = shapeAreaFactory.createShape();
        shapeCircle_3.draw();
        Area shapeCircle_3_area = shapeAreaFactory.createArea();
        shapeCircle_3_area.printAreaFormula();
    }
}
