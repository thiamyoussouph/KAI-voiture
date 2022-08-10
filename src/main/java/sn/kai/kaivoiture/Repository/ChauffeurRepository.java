package sn.kai.kaivoiture.Repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import sn.kai.kaivoiture.Entites.Chauffeur;

public interface ChauffeurRepository extends JpaAttributeConverter<Chauffeur,Integer> {

}
