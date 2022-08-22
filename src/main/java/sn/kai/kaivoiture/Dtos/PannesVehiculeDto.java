package sn.kai.kaivoiture.Dtos;


import lombok.Data;
import sn.kai.kaivoiture.Entites.Pannes;
import sn.kai.kaivoiture.Entites.Vehicules;
import java.util.Date;


@Data
public class PannesVehiculeDto {
    private int id;
    private Date  date;
    private String lieux;
    private String description;
    private Vehicules vehicules;
    private Pannes pannes;
}
