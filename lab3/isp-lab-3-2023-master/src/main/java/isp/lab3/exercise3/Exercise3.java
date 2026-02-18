package isp.lab3.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Dacia", "Logan", 400, 'B');
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setModel("Dacia");
        vehicle2.setType("Logan");
        vehicle2.setFuelType('B');
        vehicle1.setSpeed(400);
        System.out.println("Model: " + vehicle1.getModel() + "\nType: " + vehicle1.getType() + "\nFuelType: " + vehicle1.getFuelType());
        System.out.println("Model: " + vehicle2.getModel() + "\nType: " + vehicle2.getType() + "\nSpeed: " + vehicle2.getSpeed() + "\nFuelType: " + vehicle2.getFuelType());
        if (vehicle2.equals(vehicle1)) {
            System.out.println("Vehicles are equal");
        } else {
            System.out.println("Vehicles are not equal");
        }
        Vehicle.getVehicleCount();


    }
}
