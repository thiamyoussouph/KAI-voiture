package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Dtos.AffectationDto;
import sn.kai.kaivoiture.Entites.Affectation;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;
import sn.kai.kaivoiture.Mappers.AffectationMapperImplement;
import sn.kai.kaivoiture.Repository.AffectationRepository;
;

import java.util.Collection;
import java.util.stream.Collectors;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class AffectationIplement implements IaffectationService{
    AffectationRepository affectationRepository;
    AffectationMapperImplement affectationMapperImplement;
    @Override
    public Collection<AffectationDto> Listeaffection() {
        Collection<Affectation>affectations=affectationRepository.findAll();
        Collection<AffectationDto> affectationDtos= affectations.stream().map(affectation -> affectationMapperImplement.fromAffectation(affectation)).collect(Collectors.toList());
        return affectationDtos;


    }

    @Override
    public AffectationDto saveaffectation(AffectationDto affectationDto) {
        Affectation affectation=affectationMapperImplement.fromAffectationDto(affectationDto);
        Affectation affectation1=affectationRepository.save(affectation);
        return affectationMapperImplement.fromAffectation(affectation1);



    }

    @Override
    public void deleteAffactation(int id) {

    }

    @Override
    public AffectationDto update(AffectationDto affectationDto) {
        Affectation vehicules=dtopMapper.fromVehiculesDto(vehiculesDto);
        return null;
        Vehicules vehicules=dtopMapper.fromVehiculesDto(vehiculesDto);
        Vehicules savevehicule=vehiculeRepository.save(vehicules);
        return dtopMapper.fromVehicules(savevehicule);
    }

    @Override
    public AffectationDto edite(int id) {
        Affectation affectation=affectationRepository.findById(id).orElse(null);
            affectationRepository.findById(id);
        return affectationMapperImplement.fromAffectation(affectation);
    }

}
