package isp.lab5.exercise4;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        UserApp user1 = new UserApp();
        OrganizerApp organizer = new OrganizerApp();

        String string;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the ticket buying app! Please enter your name: ");
        string = sc.nextLine();
        user1.setName(string);
        System.out.println("Welcome " + user1.getName() + "!");


        boolean test = true;
        while(test)
        {
            System.out.println("Please select the paymeny method: ");
            System.out.println("1.Visa Card");
            System.out.println("2.Mastercard");
            System.out.println("3.Bank transfer");
            System.out.println("4.Exit");

            int choice1 = sc.nextInt();
            switch (choice1){
                case 1:
                    user1.setPaymentMethod(PaymentMethod.CARD_VISA);
                    System.out.println("Method: " + user1.getPaymentMethod());
                    break;
                case 2:
                    user1.setPaymentMethod(PaymentMethod.MASTER_CARD);
                    System.out.println("Method: " + user1.getPaymentMethod());
                    break;
                case 3:
                    user1.setPaymentMethod(PaymentMethod.BANK_TRANSFER);
                    System.out.println("Method: " + user1.getPaymentMethod());
                    break;
                case 4:
                    System.out.println("Thank you for choosing!");
                    test = false;
                    break;
                default:
                    System.out.println("Invalid entry!");
                    break;

            }
        }
        int ok = 1;
        while(ok!=0) {
            System.out.println("Please select the type of ticket: ");
            System.out.println("1.Early Bird");
            System.out.println("2.Basic Ticket");
            System.out.println("3.VIP Ticket");
            System.out.println("4.Full Access Ticket");
            System.out.println("5.View your ticket.");
            System.out.println("6.Exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Ticket number: " + user1.generateTicket());
                    System.out.println("You purchased the Early Bird ticket!");
                    user1.setTicketType(TicketType.EARLYBIRD);
                    break;
                case 2:
                    System.out.println("Ticket number: " + user1.generateTicket());
                    System.out.println("You purchased the Basic ticket!");
                    user1.setTicketType(TicketType.BASIC_TICKET);
                    break;
                case 3:
                    System.out.println("Ticket number: " + user1.generateTicket());
                    System.out.println("You purchased the VIP ticket!");
                    user1.setTicketType(TicketType.VIP);
                case 4:
                    System.out.println("Ticket number: " + user1.generateTicket());
                    System.out.println("You purchased the Full access ticket!");
                    user1.setTicketType(TicketType.FULL_ACCESS);
                case 5:
                    System.out.println(user1.getTicketType());
                    break;
                case 6:
                    System.out.println("Thank you for purchasing!");

                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        organizer.checkIn();
        System.out.println("Validation begins!");
        organizer.scanTicket(user1.getTicket());
    }
}