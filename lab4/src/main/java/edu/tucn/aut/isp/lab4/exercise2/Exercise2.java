package edu.tucn.aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeeder f = new FishFeeder("Eheim", "AutoFeeder", 4);
        f.toString();
        System.out.println(f);
        f.feed();
        System.out.println(f);
        f.fillUp();
        System.out.println(f);
    }
}
