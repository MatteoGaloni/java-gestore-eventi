package org.learning.java.events;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Event {
    //Attributes
    private String title;
    private LocalDate date;
    private int totalSeats;

    //starting with 0 value//
     private int bookedSeats = 0;

    //Constructors

    public Event(String title, String date, int totalSeats){
        this.title = title;
        this.date = parseAndValidateDate(date);
        this.totalSeats = validateTotalSeats(totalSeats);
    }

    //Methods//

    //Getter - Setter

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    //Custom Methods//
    private LocalDate parseAndValidateDate(String date){
        try {
            LocalDate parsedDate = LocalDate.parse(date);
            if (parsedDate.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("You can't provide a past date");
            }
            return parsedDate;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Please provide a valid format date");
        }
    }

    private int validateTotalSeats(int seatsNumber) throws IllegalArgumentException {
        if (seatsNumber <= 0 ){
            throw new IllegalArgumentException("You must enter a positive or greater than 0 number");
        }
        return seatsNumber;
    }


}
