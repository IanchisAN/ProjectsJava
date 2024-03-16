package isp.lab5.exercise4;

public enum PaymentMethod {

    CARD_VISA("Visa Card"),
    MASTER_CARD("MasterCard"),
    BANK_TRANSFER("Bank transfer");

    private String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
