package sn.kai.kaivoiture.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.kai.kaivoiture.Entites.Pannes;
import sn.kai.kaivoiture.Entites.TypesJobDeMaintenance;
import sn.kai.kaivoiture.Entites.Vehicules;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Data

public class JobDeMaintenanceDto {

    private int id;
    private Date dateDebut;
    private Date dateResolution;
    private String lieux;
    private String description;
    private boolean etat;

    private Vehicules vehicules;
    private TypesJobDeMaintenance typesJobDeMaintenance;


}
