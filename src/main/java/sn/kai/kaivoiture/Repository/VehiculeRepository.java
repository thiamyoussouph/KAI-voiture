package sn.kai.kaivoiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.kai.kaivoiture.Entites.Vehicules;

public interface VehiculeRepository extends JpaRepository<Vehicules,Integer> {

}
