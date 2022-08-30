package com.epam.rd.autotasks.figures;

import java.util.Objects;

public class Circle extends Figure {

    private final Point point;

    private final double radius;

    public Circle(Point point, double radius) {
        if(Objects.isNull(point) || radius <= 0d)
            throw new IllegalArgumentException();
        this.point = point;
        this.radius = radius;
    }

    public Point centroid() {
        return this.point;
    }

    public boolean isTheSame(Figure figure) {
        Circle circle;
        try {
            circle = (Circle) figure;
        }catch (Exception e){
            return false;
        }
        return circle.getPoint().equals(this.getPoint())
                && Math.abs(circle.getRadius() - this.getRadius()) <= 0.0001;
    }


    public Point getPoint() {
        return point;
    }

    public double getRadius() {
        return radius;
    }
}

