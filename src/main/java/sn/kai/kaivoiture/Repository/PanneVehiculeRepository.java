package sn.kai.kaivoiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.kai.kaivoiture.Entites.PannesVehicule;

import java.util.Collection;

public interface PanneVehiculeRepository  extends JpaRepository<PannesVehicule,Integer> {

}
