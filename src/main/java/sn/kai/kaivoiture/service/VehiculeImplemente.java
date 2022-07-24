package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Entites.Marque;
import sn.kai.kaivoiture.Entites.Modele;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Exception.*;
import sn.kai.kaivoiture.Repository.MarqueReposirory;
import sn.kai.kaivoiture.Repository.ModeleRepository;
import sn.kai.kaivoiture.Repository.TypesVehiculeRepository;
import sn.kai.kaivoiture.Repository.VehiculeRepository;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class VehiculeImplemente implements IVehiculeService {
    private MarqueReposirory marqueReposirory;
    private ModeleRepository modeleRepository;
    private TypesVehiculeRepository typesVehiculeRepository;
    private VehiculeRepository vehiculeRepository;

    @Override
    public Vehicules saveVehicule(Vehicules vehicules) throws MarquenotFondException {

        return vehiculeRepository.save(vehicules);
    }






    @Override
    public Collection<Vehicules> listvehicule() {
        return vehiculeRepository.findAll();
    }

    @Override
    public void deletevehicule(int id) {
        vehiculeRepository.deleteById(id);
    }


    @Override
    public Vehicules update(int id, Vehicules vehicule) throws VehiculeException {
        Vehicules vehicules=vehiculeRepository.findById(id).orElse(null);
        if (vehicules==null)
            throw new VehiculeException("ce vehicule nexiste pas dans la base de donner ");

        vehicule.setId(id);
         vehiculeRepository.save(vehicule);
        return vehicules;
    }

    @Override
    public Vehicules edite(int id) throws VehiculeExceptionEdite {
        Vehicules vehicules=vehiculeRepository.findById(id).orElse(null);
        if (vehicules==null)
            throw new VehiculeExceptionEdite("le non du model existe deja ");
        vehiculeRepository.findById(id);
        return vehicules;
    }

    @Override
    public Marque SaveMarque(Marque marque) throws MaraquenotFondException {
 Marque marque1=marqueReposirory.findById(marque.getId()).orElse(null);
 if (marque!=null)
     throw new MaraquenotFondException("le non du model existe deja ");
        return marqueReposirory.save(marque);
    }

    @Override
    public Modele SaveModele(Modele modele, int marqueId) throws ModeletFondException {
        Modele modele1=modeleRepository.findById(modele.getId()).orElse(null);
        if (modele1!=null)
            throw new ModeletFondException("ce model existe deja ");

        return modeleRepository.save(modele);
    }

}
