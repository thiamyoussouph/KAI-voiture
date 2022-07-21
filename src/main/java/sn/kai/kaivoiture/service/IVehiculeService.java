package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Entites.Marque;
import sn.kai.kaivoiture.Entites.Modele;
import sn.kai.kaivoiture.Entites.TypesVehicules;
import sn.kai.kaivoiture.Entites.Vehicules;

public interface IVehiculeService {
    Vehicules saveVehicule(Vehicules vehicules,int marqueId);
    Vehicules findbyMarque(Marque marque);
    Vehicules findbyMatricule(String Matricule);
    Marque SaveMarque(Marque marque);
    Modele SaveModele(Modele modele,int marqueId);
    TypesVehicules saveTypesvehicule(TypesVehicules typesVehicules,int modeleId);
}
