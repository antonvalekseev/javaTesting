package ru.stqa.sandbox;

public class Distance {

    public static void main(String[] args) {

        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);

        System.out.println("Расстояние = " + p1.distance(p2));

    }
}
