package com.epam.rd.autotasks.figures;


import static java.lang.Math.abs;

public class Triangle extends Figure {

    private Point first;

    private Point second;

    private Point third;

    public Triangle(Point parameter1, Point parameter2, Point parameter3) {
        this.first = parameter1;
        this.second = parameter2;
        this.third = parameter3;

        if ((first == null) || (second == null) || (third == null))
            throw new IllegalArgumentException();

        if (area() == 0)
            throw new IllegalArgumentException();

    }


    public double area() {

        double x1 = first.getX();
        double x2 = second.getX();
        double x3 = third.getX();
        double y1 = first.getY();
        double y2 = second.getY();
        double y3 = third.getY();
        return abs((x2-x1)*(y3-y1) - (x3-x1)*(y2-y1))/2;



    }
    public static Point centroid(Point p1, Point p2, Point p3) {
        double centerY = (1 / 3.) * (p1.getY() + p2.getY() + p3.getY());

        double centerX = (1 / 3.) * (p1.getX() + p2.getX() + p3.getX());

        return new Point(centerX, centerY);

    }

    @Override
    public Point centroid() {
        return centroid(this.getFirst(), this.getSecond(), this.getThird());
    }


    @Override
    public boolean isTheSame(Figure figure) {
        Triangle triangle;
        if (figure instanceof Triangle){
            triangle = (Triangle) figure;
            return checkTriangle(triangle);
        }

        return false;
    }

    boolean checkTriangle(Triangle triangle){
        return this.first.equals(triangle.getFirst())
                || this.second.equals(triangle.getSecond())
                || this.third.equals(triangle.getThird());
    }

    public Point getFirst() {
        return first;
    }

    public Point getSecond() {
        return second;
    }

    public Point getThird() {
        return third;
    }
}
