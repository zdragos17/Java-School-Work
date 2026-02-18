package isp.lab11;

import java.security.SecureRandom;
import java.util.Scanner;
import java.util.UUID;

public class Aircraft extends Thread{
    private String id;
    String lock = UUID.randomUUID().toString();
    private int altitude;


    public Aircraft(String id) {
        this.id = id;
        System.out.println("Aircraft "+id+" is created. Ready to take off.");

    }
    public void start()
    {
        Thread t = new Thread(this);
        t.start();
    }
    public void run(){

        System.out.println("Aircraft "+id+" is ON-STAND state. Ready to take off.");
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Aircraft "+id+" is started. Going in TAXI state.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Aircraft "+id+" is taking off.");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify Altitude: ");
        altitude = scanner.nextInt();
        scanner.close();
        System.out.println("Aircraft "+id+" is ascending.");
        try {
            Thread.sleep(altitude*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Aircraft "+id+" is now at "+altitude+" thousand meters.");
        long time1 = System.currentTimeMillis();
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println("Aircraft "+id+" is now landing.");
        try {
            Thread.sleep(altitude*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Aircraft "+id+" has landed. Aircraft "+id+" cruised for" +(time2-time1)/1000+" seconds.");



    }

    public void receiveAtcCommand(AtcCommand command){
        synchronized (lock){
            lock.notify();
        }
    }



}
