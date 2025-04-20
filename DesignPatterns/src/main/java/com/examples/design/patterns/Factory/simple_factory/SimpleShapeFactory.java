package com.examples.design.patterns.Factory.simple_factory;

import com.examples.design.patterns.Factory.models.Circle;
import com.examples.design.patterns.Factory.models.Rectangle;
import com.examples.design.patterns.Factory.models.Shape;

// A single factory class with a static method that returns instances based on some input.
/*
 * (+) ->   Centralized object creation
 * (+) ->   Easy to use
 * (-) ->   Not extensible (every new type needs factory changes)
 * (-) ->   Breaks Open/Closed Principle
 */
public class SimpleShapeFactory {
    public static Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else {
            throw new IllegalArgumentException("Unknown shape type");
        }
    }
}




