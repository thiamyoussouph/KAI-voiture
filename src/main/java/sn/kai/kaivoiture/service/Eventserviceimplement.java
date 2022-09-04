package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Entites.*;
import sn.kai.kaivoiture.Repository.EVentRepository;
import sn.kai.kaivoiture.Repository.IncidentRepository;
import sn.kai.kaivoiture.Repository.PAnnesRepository;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class Eventserviceimplement implements Ievent {
    @Autowired
    private EVentRepository eVentRepository;
    @Autowired
    private PAnnesRepository pAnnesRepository;
    @Autowired
    private IncidentRepository incidentRepository;
    @Override
    public Panne savpane(Panne panne) {

        return pAnnesRepository.save(panne);
    }


    @Override
    public Event saveAccident(Event event) {
        Accident accident=new Accident();
        return eVentRepository.save(accident);
    }

    @Override
    public Event saveJOb(Event event) {
        Jobs jobs=new Jobs();
        return eVentRepository.save(jobs);
    }





    @Override
    public Collection<Event> getAll() {
        return eVentRepository.findAll();
    }

}
