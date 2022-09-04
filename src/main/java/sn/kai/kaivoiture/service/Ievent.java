package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Entites.*;

import java.util.Collection;

public interface Ievent {

    Panne savpane(Panne panne);

    Event saveAccident(Event event);
    Event saveJOb(Event event);



    Collection<Event> getAll();


}
