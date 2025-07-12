package CoreJava.Lab14;

import CoreJava.Lab14.Area.*;

public class Display {
    public static void main(String[] args) {
        System.out.println("Area of rectangle: " + Rectangle.calculate(3, 4));
        System.out.println("Area of circle: " + Circle.calculate(7));
        System.out.println("Area of square: " + Square.calculate(7));
    }
}
