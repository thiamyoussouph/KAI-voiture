package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Dtos.PannesDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.Pannes;
import sn.kai.kaivoiture.Entites.Vehicules;

import java.util.Collection;


public interface IPanneService {
  PannesDto savepanne(PannesDto pannesDto);
   Collection<PannesDto> listPanne();
    PannesDto findbyid(int id);
    PannesDto update( PannesDto pannesDto);
   void delete(int id);

}
