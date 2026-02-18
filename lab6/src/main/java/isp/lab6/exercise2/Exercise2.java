package isp.lab6.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
    Vehicle vehicle1=new Vehicle("MM17NVD", 2020,"Q5","VIN1","Audi");
    Vehicle vehicle2=new Vehicle("MM",2020,"Q5","VIN2","Audi");
    VehicleRegistry vehicleRegistry=new VehicleRegistry();
    vehicleRegistry.addVehicle(vehicle1);
    vehicleRegistry.addVehicle(vehicle2);
    vehicleRegistry.displayVehicles();
    vehicleRegistry.removeVehicle(new Vehicle("VIN1"));
    vehicleRegistry.displayVehicles();

    }
}
