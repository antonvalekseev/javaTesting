package ru.stqa.sandbox;

public class Point {
    double xa;
    double xb;
    double ya;
    double yb;

    public Point(double xa, double xb, double ya, double yb) {
        this.xa = xa;
        this.xb = xb;
        this.ya = ya;
        this.yb = yb;
    }

    public double distance() {
        return Math.sqrt(Math.pow((this.xb - this.xa),2) + Math.pow((this.yb - this.ya),2));
    }
}