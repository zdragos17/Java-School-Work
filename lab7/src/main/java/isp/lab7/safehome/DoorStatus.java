package isp.lab7.safehome;

public enum DoorStatus {
    OPEN, CLOSE;
    private void display() {
        switch (this) {
            case OPEN:
                System.out.println("Open");
                break;
                case CLOSE:
                    System.out.println("Close");
                    break;
                    default:
                        System.out.println("Unknown");
                        break;

        }
    }
}
