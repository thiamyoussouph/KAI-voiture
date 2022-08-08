package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Entites.Pannes;
import sn.kai.kaivoiture.Repository.PanneRepository;
import sn.kai.kaivoiture.Repository.VehiculeRepository;

import java.util.Collection;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PannesIplement implements IPanneService{
    PanneRepository panneRepository;



    @Override
    public Pannes savepanne(Pannes pannes) {

        return panneRepository.save(pannes);
    }

    @Override
    public Collection<Pannes> listPanne() {
        return panneRepository.findAll();
    }


    @Override
    public Pannes findbyid(int id) {
        return null;
    }

    @Override
    public Pannes update(int id, Pannes pannes) {
        return null;
    }
}
