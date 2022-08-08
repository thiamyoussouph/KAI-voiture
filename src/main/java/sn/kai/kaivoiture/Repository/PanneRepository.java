package sn.kai.kaivoiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.kai.kaivoiture.Entites.Pannes;

public interface PanneRepository extends JpaRepository<Pannes,Integer> {
}
