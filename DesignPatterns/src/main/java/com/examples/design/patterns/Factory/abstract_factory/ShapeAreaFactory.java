package com.examples.design.patterns.Factory.abstract_factory;

import com.examples.design.patterns.Factory.models.Area;
import com.examples.design.patterns.Factory.models.Shape;

public interface ShapeAreaFactory {
    Shape createShape();
    Area createArea();
}
