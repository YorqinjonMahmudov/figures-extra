package com.epam.rd.autotasks.figures;

class Point {
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

     public boolean equals(Point p) {
        return Math.abs(p.getX() - this.getX()) <= 0.0001
                && Math.abs(p.getY() - this.getY()) <= 0.0001;
    }

}
