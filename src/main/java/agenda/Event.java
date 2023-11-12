package agenda;

import java.time.*;
import java.time.chrono.ChronoLocalDate;

public class Event {
    private String myTitle;

    private LocalDateTime myStart;


    private Duration myDuration;



    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    public boolean isInDay(LocalDate aDay) {
        // TODO : implémenter cette méthode
        if((aDay.getDayOfYear() == myStart.getDayOfYear() &&  aDay.getYear() == myStart.getYear())
                || (aDay.getDayOfYear() == myStart.plus(myDuration).getDayOfYear() && aDay.getYear() == myStart.plus(myDuration).getYear())
                || (aDay.isAfter(ChronoLocalDate.from(myStart)) && aDay.isBefore(ChronoLocalDate.from(myStart.plus(myDuration))))){
            return true;
        }
        return false;
    }

    public String getTitle() {
        return myTitle;
    }


    protected LocalDateTime getStart() {
        return myStart;
    }



    protected Duration getDuration() {
        return myDuration;
    }


    public String toString(){
        return myTitle;
    }
}