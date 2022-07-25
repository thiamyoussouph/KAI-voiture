package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Entites.Modele;
import sn.kai.kaivoiture.Repository.ModeleRepository;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ModelIplement implements Imodele {
    private ModeleRepository modeleRepository;
    @Override
    public Collection<Modele> ListeModele() {
        return modeleRepository.findAll();
    }
}
