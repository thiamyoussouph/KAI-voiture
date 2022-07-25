package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Entites.TypesVehicules;
import sn.kai.kaivoiture.Repository.TypesVehiculeRepository;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class TypesVehiculeImplement implements ItypesVehicule {
    TypesVehiculeRepository typesVehiculeRepository;
    @Override
    public Collection<TypesVehicules> ListetypesVehicule() {
        return typesVehiculeRepository.findAll();
    }
}
