package isp.lab5.exercise4;

import java.util.Random;

public class UserApp implements TicketsManager{
    private String name;
    private TicketType ticketType;
    private int ticket;
    private PaymentMethod paymentMethod;

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getName() {
        return name;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public Object setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
        return null;
    }

    public Object buyTicket(){
        System.out.println("You have bought a " + this.ticketType);
        return null;
    }

    public void viewTicket(){
        System.out.println("Your ticket is of type " + this.ticketType);
    }

    @Override
    public int generateTicket() {
        Random random = new Random();
        this.ticket = random.nextInt(10000);
        System.out.println("You have bought the ticket with the number " + ticket);
        return 0;
    }

    @Override
    public int validateTicket() {
        System.out.println("Ticket Validated");

        return 0;
    }
}
