package ru.stqa.sandbox;

public class MyFirstProgram {

    public static void main(String... args) {

        Square s = new Square(11);
        System.out.println(s.squareArea());

        Rectangle r = new Rectangle(13.5, 12.9);
        System.out.println(r.rectangleArea());

        //run via function
        double xa = 2.3556;
        double xb = 3.2464;
        double ya = 4.3907;
        double yb = 5.7832;
        System.out.println("Distance between points with coordinates " + xa + ", " + xb + ", " + ya + ", " + yb + " is: " +distance(xa, xb, ya, yb));

        //run via method in Point class
        Point points = new Point(2.3556, 3.2464, 4.3907, 5.7832);
        System.out.println("Distance between points with coordinates " + points.xa + ", " + points.xb + ", " + points.ya + ", " + points.yb + " is: " + points.distance());
    }

    public static double distance(double xa, double xb, double ya, double yb) {
        return Math.sqrt(Math.pow((xb - xa), 2) + Math.pow((yb - ya), 2));
    }
}