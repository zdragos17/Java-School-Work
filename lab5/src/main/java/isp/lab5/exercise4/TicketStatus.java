package isp.lab5.exercise4;

public enum TicketStatus {
VALID("Valid"),
    INVALID("Invalid"),
    USED("Used");

    private String displayStatus;

    TicketStatus(String displayStatus) {
        this.displayStatus = displayStatus;
    }
}
