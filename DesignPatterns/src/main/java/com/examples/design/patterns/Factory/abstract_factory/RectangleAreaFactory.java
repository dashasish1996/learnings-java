package com.examples.design.patterns.Factory.abstract_factory;

import com.examples.design.patterns.Factory.models.Area;
import com.examples.design.patterns.Factory.models.Rectangle;
import com.examples.design.patterns.Factory.models.RectangleArea;
import com.examples.design.patterns.Factory.models.Shape;

public class RectangleAreaFactory implements ShapeAreaFactory{
    @Override
    public Shape createShape() {
        return new Rectangle();
    }

    @Override
    public Area createArea() {
        return new RectangleArea();
    }
}
