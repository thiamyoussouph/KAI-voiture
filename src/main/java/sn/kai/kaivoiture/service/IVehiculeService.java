package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Entites.Marque;
import sn.kai.kaivoiture.Entites.Modele;
import sn.kai.kaivoiture.Entites.TypesVehicules;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Exception.*;

import java.util.Collection;

public interface IVehiculeService {
    Vehicules saveVehicule(Vehicules vehicules) throws MarquenotFondException;



    Collection<Vehicules> listvehicule();
    public void  deletevehicule(int id);
    Vehicules update(int id, Vehicules vehicule) throws VehiculeException;

    Vehicules edite(int id) throws VehiculeExceptionEdite;

    Marque SaveMarque(Marque marque) throws MaraquenotFondException;

    Modele SaveModele(Modele modele, int marqueId) throws ModeletFondException;

}
