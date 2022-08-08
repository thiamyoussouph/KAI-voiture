package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Entites.PannesVehicule;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Repository.PanneVehiculeRepository;
import sn.kai.kaivoiture.Repository.VehiculeRepository;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PanneVehiculeImplement implements IPannevehiculeService{
    PanneVehiculeRepository panneVehiculeRepository;
    VehiculeRepository vehiculeRepository;
    VehiculeImplemente vehiculeImplemente;
    @Override
    public PannesVehicule savepannevehicule(PannesVehicule pannesVehicule) {

        return panneVehiculeRepository.save(pannesVehicule);
    }

    @Override
    public Collection<PannesVehicule> findall() {
        return panneVehiculeRepository.findAll();
    }

    @Override
    public PannesVehicule findbyid(int id) {
        return null;
    }

    @Override
    public PannesVehicule update(int id, PannesVehicule pannesVehicule) {
        return null;
    }
}
