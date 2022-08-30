package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Quadrilateral extends Figure {

    private final Point point1;
    private final Point point2;
    private final Point point3;
    private final Point point4;

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        isNull(p1, p2, p3, p4);
        check(p1, p2, p3, p4);
        this.point1 = p1;
        this.point2 = p2;
        this.point3 = p3;
        this.point4 = p4;

    }

    public Point centroid() {
        Point point1 = Triangle.centroid(this.getPoint1(), this.getPoint2(), this.getPoint3());
        Point point2 = Triangle.centroid(this.getPoint2(), this.getPoint3(), this.getPoint4());
        Point point3 = Triangle.centroid(this.getPoint3(), this.getPoint4(), this.getPoint1());
        Point point4 = Triangle.centroid(this.getPoint4(), this.getPoint1(), this.getPoint2());

        double k1 = (point1.getY() - point3.getY()) / (point1.getX() - point3.getX());
        double k2 = (point2.getY() - point4.getY()) / (point2.getX() - point4.getX());

        double b1 = point1.getY() - point1.getX() * k1;
        double b2 = point2.getY() - point2.getX() * k2;

        double x = (b1 - b2) / (k2 - k1);
        double y = k1 * x + b1;
        return new Point(x, y);
    }

    public boolean isTheSame(Figure figure) {
        Quadrilateral quadrilateral;
        try {
            quadrilateral = (Quadrilateral) figure;
        } catch (Exception e) {
            return false;
        }
        return isThere(quadrilateral.getPoint1())
                && isThere(quadrilateral.getPoint2())
                && isThere(quadrilateral.getPoint3())
                && isThere(quadrilateral.getPoint4());
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public Point getPoint4() {
        return point4;
    }

    private void check(Point p1, Point p2, Point p3, Point p4) {
        checkPart(p1, p2, p3, p4);
        checkPart(p2, p3, p4, p1);
        checkPart(p3, p4, p1, p2);
        checkPart(p4, p1, p2, p3);
    }

    private void checkPart(Point p1, Point p2, Point p3, Point p4) {
        double k, b, x1, x2, y1, y2;
        if ((p1.getX() - p2.getX()) == 0 || (p1.getY() - p2.getY()) == 0) {
            if (p1.getX() == p2.getX()) {
                x1 = x2 = p1.getX();
                if (!((x1 > p3.getX() && x2 > p4.getX())
                        || (x1 < p3.getX() && x2 < p4.getX())))
                    throw new IllegalArgumentException();
            } else if (p1.getY() == p2.getY()) {
                y1 = y2 = p1.getY();
                if (!((y1 > p3.getY() && y2 > p4.getY())
                        || (y1 < p3.getY() && y2 < p4.getY())))
                    throw new IllegalArgumentException();
            } else
                throw new IllegalArgumentException();
        } else {
            k = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
            b = p1.getY() - p1.getX() * k;

            x1 = (p3.getY() - b) / k;
            x2 = (p4.getY() - b) / k;
            y1 = p3.getX() * k + b;
            y2 = p4.getX() * k + b;

            if (!((p3.getX() > x1 && p4.getX() > x2)
                    || (p3.getX() < x1 && p4.getX() < x2)
                    || (p3.getY() > y1 && p4.getY() > y2)
                    || (p3.getY() < y1 && p4.getY() < y2)))
                throw new IllegalArgumentException();
        }
    }

    private void isNull(Point p1, Point p2, Point p3, Point p4) {
        if (Objects.isNull(p1)
                || Objects.isNull(p2)
                || Objects.isNull(p3)
                || Objects.isNull(p4))
            throw new IllegalArgumentException();
    }

    private boolean isThere(Point point) {
        return this.getPoint1().equals(point)
                || this.getPoint2().equals(point)
                || this.getPoint3().equals(point)
                || this.getPoint4().equals(point);
    }
}
