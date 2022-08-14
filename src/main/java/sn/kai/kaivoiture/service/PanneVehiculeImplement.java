package sn.kai.kaivoiture.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Dtos.PannesVehiculeDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.PannesVehicule;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;
import sn.kai.kaivoiture.Mappers.PannesVehiculeMapperImplement;
import sn.kai.kaivoiture.Mappers.VehiculesMapperIplement;
import sn.kai.kaivoiture.Repository.PanneVehiculeRepository;
import sn.kai.kaivoiture.Repository.VehiculeRepository;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import static sn.kai.kaivoiture.enums.VehiculeSatus.Innactif;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PanneVehiculeImplement implements IPannevehiculeService{
    PanneVehiculeRepository panneVehiculeRepository;
    VehiculeRepository vehiculeRepository;
    VehiculeImplemente vehiculeImplemente;
    PannesVehiculeMapperImplement pannesVehiculeMapperImplement;
    VehiculesMapperIplement vehiculesMapperIplement;
    @Override
    public PannesVehiculeDto savepannevehicule(PannesVehiculeDto pannesVehiculeDto) {
        PannesVehicule pannesVehicule=pannesVehiculeMapperImplement.fromPanneVehiculeDto(pannesVehiculeDto);
        PannesVehicule pannesVehicule1=panneVehiculeRepository.save(pannesVehicule);
        return pannesVehiculeMapperImplement.frompanneVeicule(pannesVehicule1);
    }

    @Override
    public Collection<PannesVehiculeDto> findall() {
        Collection<PannesVehicule>pannesVehicules= panneVehiculeRepository.findAll();
        Collection<PannesVehiculeDto> pannesVehiculeDtos= pannesVehicules.stream().map(pannesVehicule ->pannesVehiculeMapperImplement.frompanneVeicule(pannesVehicule)).collect(Collectors.toList());
        return pannesVehiculeDtos;



    }

    @Override
    public PannesVehiculeDto findbyid(int id) {
        PannesVehicule pannesVehicule=panneVehiculeRepository.findById(id).orElse(null);
        panneVehiculeRepository.findById(id);
        return pannesVehiculeMapperImplement.frompanneVeicule(pannesVehicule);

    }

    @Override
    public PannesVehiculeDto update(int id, PannesVehiculeDto pannesVehiculeDto, VehiculesDto vehiculesDto) {
        PannesVehicule pannesVehicule=pannesVehiculeMapperImplement.fromPanneVehiculeDto(pannesVehiculeDto);
        PannesVehicule pannesVehicule1=panneVehiculeRepository.save(pannesVehicule);
        return pannesVehiculeMapperImplement.frompanneVeicule(pannesVehicule1);
    }

    @Override
    public PannesVehiculeDto savepanneve(PannesVehiculeDto pannesVehiculeDto, int vehiculeid) {

        PannesVehicule pannesVehicule=pannesVehiculeMapperImplement.fromPanneVehiculeDto(pannesVehiculeDto);
    Vehicules vehicule= vehiculeRepository.findById(vehiculeid).orElseThrow();

        vehicule.setStatus(Innactif);

        PannesVehicule pannesVehicule1=panneVehiculeRepository.save(pannesVehicule);

        return pannesVehiculeMapperImplement.frompanneVeicule(pannesVehicule1);
    }
    @Override
    public void deletePannevehicule(int id) {
        panneVehiculeRepository.deleteById(id);
    }

}
