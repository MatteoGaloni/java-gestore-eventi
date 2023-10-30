package org.learning.java.events;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.text.DecimalFormat;


public class Concert extends Event{

    private LocalTime time;
    private BigDecimal price;

    public Concert(String title, String date, int totalSeats, String time, BigDecimal price) {
        super(title, date, totalSeats);
        this.time = parseAndValidateTime(time);
        this.price = price;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    private LocalTime parseAndValidateTime(String time){
        try {
            LocalDate eventDate = getDate();
            LocalTime parsedTime = LocalTime.parse(time);
            if (parsedTime.isBefore(LocalTime.now()) && eventDate.isEqual(LocalDate.now())) {
                throw new IllegalArgumentException("You can't provide a past time");
            }
            return parsedTime;
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Please provide a valid format time");
        }
    }


    public String getFormattedPrice() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(getPrice());
    }




    @Override
    public String toString() {
        return " Date= " + getFormattedDate() + " Title= " + getTitle() + " Time= " + getTime() + " Price= " + getFormattedPrice() + "€";
    }
}
