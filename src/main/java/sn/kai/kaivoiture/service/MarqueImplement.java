package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Entites.Marque;
import sn.kai.kaivoiture.Repository.MarqueReposirory;
import sn.kai.kaivoiture.Repository.ModeleRepository;
import sn.kai.kaivoiture.Repository.TypesVehiculeRepository;
import sn.kai.kaivoiture.Repository.VehiculeRepository;

import java.util.Collection;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class MarqueImplement implements Imarque{
    private MarqueReposirory marqueReposirory;

    @Override
    public Collection<Marque> ListeMarque() {
        return marqueReposirory.findAll();
    }
}
