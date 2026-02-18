package edu.tucn.aut.isp.lab4.exercise5;

public class FishFeeder {
    private String manufacturer;
    private String model;
    private int meals;

    public FishFeeder(String manufacturer, String model, int meals) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = meals;
    }

    public FishFeeder() {
    }

    public void fillUp() {
        this.meals = 14;
    }

    public void feed() {
        if (this.meals > 0) {

            this.meals--;
            System.out.println("Pestele a primit mancare. " + "Mese ramase : " + this.meals);
        } else System.out.println("Nu mai este mancare");
    }

    public int getMeals() {
        return meals;
    }


    @Override
    public String toString() {
        return "FishFeeder{" + "manufacturer='" + manufacturer + '\'' + ", model='" + model + '\'' + ", meals=" + meals + '}';
    }
}
