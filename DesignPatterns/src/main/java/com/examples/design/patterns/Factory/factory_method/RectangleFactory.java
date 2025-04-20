package com.examples.design.patterns.Factory.factory_method;

import com.examples.design.patterns.Factory.models.Rectangle;
import com.examples.design.patterns.Factory.models.Shape;

public class RectangleFactory implements ShapeFactory{
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
