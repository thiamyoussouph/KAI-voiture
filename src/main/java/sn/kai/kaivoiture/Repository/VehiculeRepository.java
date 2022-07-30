package sn.kai.kaivoiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.kai.kaivoiture.Entites.Modele;
import sn.kai.kaivoiture.Entites.Vehicules;
@RepositoryRestResource()
public interface VehiculeRepository extends JpaRepository<Vehicules,Integer> {



}
