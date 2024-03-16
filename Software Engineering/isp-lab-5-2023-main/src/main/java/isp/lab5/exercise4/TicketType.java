package isp.lab5.exercise4;

public enum TicketType {
    EARLYBIRD("Early-bird ticket"),
    BASIC_TICKET("Basic Ticket"),
    VIP("VIP Ticket"),
    FULL_ACCESS("Full Access Ticket");

    private String displayName;

    TicketType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
