package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 *
 */
public class Agenda {
    private ArrayList<Event> thoseEvents;

    public Agenda(){
        this.thoseEvents = new ArrayList<>();
    }
    public void addEvent(Event e) {
        thoseEvents.add(e);

    }


    /**
     * Computes the events that occur on a given day
     *
     * @param day the day to i test
     * @return a list of events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        List<Event> thoseEventsDay = new ArrayList<Event>();
        for (int i = 0; i < thoseEvents.size(); i ++){
            if (thoseEvents.get(i).isInDay(day)){
                thoseEventsDay.add(thoseEvents.get(i));
            }
        }
        //
        return thoseEventsDay;
    }

    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        ArrayList<Event> listeTitre = new ArrayList<Event>();
        for (Event e : thoseEvents){
            if(e.getTitle().equals(title)){
                listeTitre.add(e);
            }
        }
        return listeTitre;
    }

    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        Boolean b =true;
        for (Event ev : thoseEvents){
            if (ev.getStart().isBefore(e.getStart())){
                if (ev.getStart().plus(ev.getDuration()).isAfter(e.getStart()) ){
                    b=false;
                }
            } else if (ev.getStart().equals(e.getStart())){
                b=false;
            }
            if (ev.getStart().isAfter(e.getStart())){
                if (e.getStart().plus(e.getDuration()).isAfter(ev.getStart()) ){
                    b=false;
                }}
        }
        return b;
    }


}