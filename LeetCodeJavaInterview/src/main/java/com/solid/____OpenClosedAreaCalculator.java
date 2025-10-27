package com.solid;


import java.util.List;


interface Shape {
    double area();
}

class Circle implements Shape {
    public double area() { return Math.PI * 5 * 5; }
}
class Square implements Shape {
    public double area() { return 4 * 4; }
}

public class ____OpenClosedAreaCalculator {
    double totalArea(List<Shape> shapes) {
        return shapes.stream().mapToDouble(Shape::area).sum();
    }
}
