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

    public void bookSeats(int seatsNumber) throws IllegalArgumentException{
        int availableSeats = totalSeats - bookedSeats;
        if (this.date.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Sorry, the event is no longer available");
        } else if( availableSeats < seatsNumber || seatsNumber <= 0 ){
            throw new IllegalArgumentException("Sorry. you are exceeding the available number of seats. Available seats are " + availableSeats + " or you are entering a not positive number ");
        } else bookedSeats += seatsNumber;
    }

    public void deleteBookedSeats(int seatsNumber) throws IllegalArgumentException{
        if (seatsNumber <= 0){
            throw new IllegalArgumentException("Please enter a positive or greater than 0 number");
        } else if (bookedSeats - seatsNumber < 0) {
            throw new IllegalArgumentException("You can't delete your reservation, please enter a smaller number");
        } else bookedSeats -= seatsNumber;

    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", totalSeats=" + totalSeats +
                ", bookedSeats=" + bookedSeats +
                '}';
    }
}
