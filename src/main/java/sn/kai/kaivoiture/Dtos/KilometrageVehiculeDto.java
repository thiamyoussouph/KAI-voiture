package sn.kai.kaivoiture.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.kai.kaivoiture.Entites.Vehicules;

import javax.persistence.*;
import java.util.Date;


@Data
public class KilometrageVehiculeDto {

    private int id;
    private long kilometrage;
    private Date dateEnregistrement;

    Vehicules vehicules;
}
