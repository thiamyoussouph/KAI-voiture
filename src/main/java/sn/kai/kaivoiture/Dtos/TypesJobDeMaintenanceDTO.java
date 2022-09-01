package sn.kai.kaivoiture.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.kai.kaivoiture.Entites.JobDeMaintenance;

import javax.persistence.*;


@Data
public class TypesJobDeMaintenanceDTO {
    private int id;
    private String libelle;
}