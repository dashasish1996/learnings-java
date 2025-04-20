package com.examples.design.patterns.Factory.abstract_factory;

import com.examples.design.patterns.Factory.models.Area;
import com.examples.design.patterns.Factory.models.Circle;
import com.examples.design.patterns.Factory.models.CircleArea;
import com.examples.design.patterns.Factory.models.Shape;

public class CircleAreaFactory implements ShapeAreaFactory{
    @Override
    public Shape createShape() {
        return new Circle();
    }

    @Override
    public Area createArea() {
        return new CircleArea();
    }
}
