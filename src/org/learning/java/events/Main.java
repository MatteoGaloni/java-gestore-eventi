package org.learning.java.events;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Event xmasConcert = new Event("Xmas Concert", "2023-10-30",200);
        Scanner scan = new Scanner (System.in);
        boolean exit = false;

        try {
            Concert revinck = new Concert("Xmas Concert", "2023-10-30", 200, "15:06:45", new BigDecimal("12.5"));
            System.out.println(revinck);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        while (!exit) {
            try {
                System.out.println("Would you create a new Event?: y - n");
                if (scan.nextLine().equals("y")) {
                    System.out.println("Enter event title:");
                    String title = scan.nextLine();
                    System.out.println("Enter event date 'YY-MM-DD':");
                    String date = scan.nextLine();
                    System.out.println("Enter seats total number:");
                    int totalSeats = Integer.parseInt(scan.nextLine());
                    Event event = new Event(title, date, totalSeats);
                    System.out.println("Event created: " + event);

                    System.out.println("Would you like to book seats? y - n");
                    if (scan.nextLine().equals("y")) {
                        while (true) {
                            try {
                                System.out.println("How many seats would you like to book?: ");
                                int seatsToBook = Integer.parseInt(scan.nextLine());
                                event.bookSeats(seatsToBook);
                                System.out.println("You've booked " + seatsToBook + " seats." +
                                        " There are still " +
                                        (event.getTotalSeats() - event.getBookedSeats()) +
                                        " seats available");

                                System.out.println("Would you like to cancel your reservation? y - n");
                                if (scan.nextLine().equals("y")) {
                                    while (true) {
                                        try {
                                            System.out.println("How many seats would you like to cancel?: ");
                                            int canceledSeats = Integer.parseInt(scan.nextLine());
                                            event.deleteBookedSeats(canceledSeats);
                                            System.out.println("You've canceled " + canceledSeats + " seats. " +
                                                    "There are still " +
                                                    (event.getTotalSeats() - event.getBookedSeats()) +
                                                    " seats available");
                                            break;
                                        } catch (IllegalArgumentException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    }
                                }
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                } else {
                    exit = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        scan.close();
    }
}
