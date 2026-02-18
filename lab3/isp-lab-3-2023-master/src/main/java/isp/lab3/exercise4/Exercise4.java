package isp.lab3.exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(4, 3, 2);
        MyPoint point2 = new MyPoint();
        System.out.println("Distance 1: " + point1.distance(point2));
        System.out.println("Distance 2: " + point2.distance(3, 2, 9));

    }
}
