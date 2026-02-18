package isp.lab10.raceapp;

public class Timer extends Thread {
    private long totalTime = 0;
    private boolean running = true;

    public long getTotalTime() {
        return totalTime;
    }

    public void run() {
        while (running) {
            try {
                totalTime += 10;
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void stopTimer() {
        running = false;

    }


}
