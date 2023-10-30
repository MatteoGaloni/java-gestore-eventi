package org.learning.java.events;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Collections;

public class EventsProgram {
    private String title;
    private List<Event> events;

    public EventsProgram(String title) {
        this.title = title;
        this.events = new ArrayList<>();
    }
    public void addEvent(Event event){
        this.events.add(event);
    }

    public List<Event> findDateEvents(LocalDate date) {
        List<Event> findDateEvents = new ArrayList<>();
        for (Event e: this.events) {
            if(e.getDate().equals(date)){
                findDateEvents.add(e);
            }
        }
        return findDateEvents;
    }

    public int countEvents(){
        return events.size();
    }

    public void clearEvents() {
        events.clear();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Titolo del programma: ").append(title).append("\n");


        events.sort((e1, e2) -> e1.getDate().compareTo(e2.getDate()));

        for (Event event : events) {
            result.append(getFormattedEventInfo(event)).append("\n");
        }

        return result.toString();
    }

    private String getFormattedEventInfo(Event event) {
        return event.getFormattedDate() + " - " + event.getTitle();
    }
}
