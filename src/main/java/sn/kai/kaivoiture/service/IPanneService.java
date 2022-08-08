package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Entites.Pannes;

import java.util.Collection;


public interface IPanneService {
  Pannes savepanne( Pannes pannes);
   Collection<Pannes> listPanne();
    Pannes findbyid(int id);
    Pannes update(int id, Pannes pannes);

}
