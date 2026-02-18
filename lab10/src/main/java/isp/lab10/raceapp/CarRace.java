package isp.lab10.raceapp;

import javax.swing.*;
import java.awt.*;

public class CarRace {


}

class Car extends Thread {
    private String name;
    private int distance = 0;
    private CarPanel carPanel;


    public Car(String name, CarPanel carPanel) {
        //set thread name;
        setName(name);
        this.name = name;
        this.carPanel = carPanel;
    }

    public void run() {
        while (distance < 400) {
            // simulate the car moving at a random speed
            int speed = (int) (Math.random() * 10) + 1;
            distance += speed;

            carPanel.updateCarPosition(name, distance);

            try {
                // pause for a moment to simulate the passage of time
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        carPanel.carFinished(name);
    }
}

class CarPanel extends JPanel {
    private int[] carPositions;
    private String[] carNames;
    private Color[] carColors;
    private long startTime;
    private String results="";
    private int positions = 0;
    private Timer timer;

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public CarPanel() {
        carPositions = new int[4];
        carNames = new String[]{"Red car", "Blue car", "Green car", "Yellow car"};
        carColors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 4; i++) {
            int yPos = 50 + i * 50; // Vertical position of the car
            int xPos = carPositions[i]; // Horizontal position of the car
            int carSize = 30; // Size of the car

            g.setColor(carColors[i]);
            g.fillOval(xPos, yPos, carSize, carSize);
            g.setColor(Color.BLACK);
            g.drawString(carNames[i], xPos, yPos - 5);
        }
    }

    public void updateCarPosition(String carName, int distance) {
        int carIndex = getCarIndex(carName);
        if (carIndex != -1) {
            carPositions[carIndex] = distance;
            repaint();
        }
    }

    public synchronized void carFinished(String carName) {
        long duration = System.currentTimeMillis() - startTime;
        positions++;
        results += positions + ". " + carName + " - " + duration + " ms\n";

        if (positions == 4) {
            timer.stopTimer();
            results += "\n  totalTime" + timer.getTotalTime()+ " ms";
            JOptionPane.showMessageDialog(this, results, "Race results", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private int getCarIndex(String carName) {
        for (int i = 0; i < 4; i++) {
            if (carNames[i].equals(carName)) {
                return i;
            }
        }
        return -1;
    }
}
