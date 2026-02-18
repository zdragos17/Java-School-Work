package isp.lab5.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        Laptop laptop=new Laptop(20);
        SmartPhone smartPhone=new SmartPhone(20);
        SmartWatch smartWatch=new SmartWatch(20);
        laptop.charge(20);
        System.out.println(laptop.getBatteryLevel());
        smartPhone.charge(20);
        System.out.println(smartPhone.getBatteryLevel());
        smartWatch.charge(20);
        System.out.println(smartWatch.getBatteryLevel());
        laptop.charge(-20);
        laptop.charge(500);
        System.out.println(laptop.getBatteryLevel());
    }
}
