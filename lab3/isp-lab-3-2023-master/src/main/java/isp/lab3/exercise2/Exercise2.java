package isp.lab3.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(12, 10);
        Rectangle rectangle2 = new Rectangle(10, 2, "green");
        int length1 = rectangle1.getLength();
        int width1 = rectangle1.getWidth();
        int length2 = rectangle2.getLength();
        int width2 = rectangle2.getWidth();
        String color2 = rectangle2.getColor();
        String color1 = rectangle1.getColor();
        int area1 = rectangle1.getArea();
        int area2 = rectangle2.getArea();
        int perimeter1 = rectangle1.getPerimeter();
        int perimeter2 = rectangle2.getPerimeter();
        System.out.println("Rectangle1: " + length1 + " " + width1 + " " + color1 + " " + area1 + " " + perimeter1);
        System.out.println("Rectangle2: " + length2 + " " + width2 + " " + color2 + " " + area2 + " " + perimeter2);

    }
}
