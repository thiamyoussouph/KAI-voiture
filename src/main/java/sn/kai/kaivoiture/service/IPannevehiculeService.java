package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Entites.PannesVehicule;
import sn.kai.kaivoiture.Entites.Vehicules;

import java.util.Collection;

public interface IPannevehiculeService {
    PannesVehicule savepannevehicule( PannesVehicule pannesVehicule);
    Collection<PannesVehicule> findall();
    PannesVehicule findbyid(int id);
    PannesVehicule update(int id, PannesVehicule pannesVehicule);
}
