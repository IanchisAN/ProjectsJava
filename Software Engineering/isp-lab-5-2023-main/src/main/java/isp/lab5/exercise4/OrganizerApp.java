package isp.lab5.exercise4;

import java.util.Scanner;

public class OrganizerApp implements TicketsManager{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void checkIn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        name = sc.nextLine();
        setName(name);
        System.out.println("Welcome organizer " + getName() + "!");
    }
    @Override
    public int generateTicket() {
        return 0;
    }

    @Override
    public int validateTicket() {
        System.out.println("Your ticket is validated!");
        return 0;
    }

    public void scanTicket(int ticket){
        if(ticket == (int)ticket)
            System.out.println("Ticket is validated!");
        else
            System.out.println("Ticket is invalid!");
    }
}
