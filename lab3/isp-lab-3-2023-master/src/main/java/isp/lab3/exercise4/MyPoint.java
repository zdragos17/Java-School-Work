package isp.lab3.exercise4;

public class MyPoint {

    private int x;
    private int y;
    private int z;

    public MyPoint() {
        x = 0;
        y = 0;
        z = 0;
    }

    public MyPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;

    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;

    }

    public void setXYZ(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "MyPoint{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    public double distance(int x, int y, int z) {
        double distance = Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2) + Math.pow((this.z - z), 2));
        return distance;
    }

    public double distance(MyPoint other) {
        double distance = Math.sqrt(Math.pow((this.x - other.x), 2) + Math.pow((this.y - other.y), 2) + Math.pow((this.z - other.z), 2));
        return distance;
    }
}
