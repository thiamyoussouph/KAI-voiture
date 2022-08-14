package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Dtos.PannesDto;
import sn.kai.kaivoiture.Entites.Pannes;
import sn.kai.kaivoiture.Mappers.PanneMapperIplement;
import sn.kai.kaivoiture.Repository.PanneRepository;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PannesIplement implements IPanneService{
    PanneRepository panneRepository;

PanneMapperIplement panneMapperIplement;

    @Override
    public PannesDto savepanne(PannesDto pannesDto) {
        Pannes pannes=panneMapperIplement.fromPannesDto(pannesDto);
        Pannes pannes1=panneRepository.save(pannes);
        return panneMapperIplement.fromPanne(pannes1);
    }




    @Override
    public Collection<PannesDto> listPanne() {
        Collection<Pannes>pannes= panneRepository.findAll();
        Collection<PannesDto> pannesDtos= pannes.stream().map(panne ->panneMapperIplement.fromPanne(panne)).collect(Collectors.toList());
        return pannesDtos;
    }


    @Override
    public PannesDto findbyid(int id) {
        Pannes pannes=panneRepository.findById(id).orElse(null);
        panneRepository.findById(id);
        return panneMapperIplement.fromPanne(pannes);
    }

    @Override
    public PannesDto update(PannesDto pannesDto) {
        Pannes pannes=panneMapperIplement.fromPannesDto(pannesDto);
        Pannes panne=panneRepository.save(pannes);
        return panneMapperIplement.fromPanne(panne);
    }

    @Override
    public void delete(int id) {
       panneRepository.deleteById(id);
    }


}
