package com.examples.design.patterns.Factory.factory_method;

import com.examples.design.patterns.Factory.models.Circle;
import com.examples.design.patterns.Factory.models.Shape;

public class CircleFactory implements ShapeFactory{
    @Override
    public Shape createShape() {
        return new Circle();
    }
}
