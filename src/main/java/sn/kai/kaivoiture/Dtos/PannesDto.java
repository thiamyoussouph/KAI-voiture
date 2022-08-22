package sn.kai.kaivoiture.Dtos;
import lombok.Data;
import sn.kai.kaivoiture.Entites.PannesVehicule;

import java.util.Collection;


@Data

public class PannesDto {

    private int id;
    private  String libellet;
    private Collection<PannesVehicule> pannesVehicules;

}
