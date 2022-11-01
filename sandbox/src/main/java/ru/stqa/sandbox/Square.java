package ru.stqa.sandbox;

public class Square {
    public double length;

    public Square(double l) {
        this.length = l;
    }

    public double squareArea() {
        return this.length * this.length;
    }
}