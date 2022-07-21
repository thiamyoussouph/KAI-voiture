package sn.kai.kaivoiture.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.kai.kaivoiture.enums.VehiculeSatus;
import sn.kai.kaivoiture.enums.vehiculeEtats;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Vehicules {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name = "Matricule",unique = true,length = 8)
    private String Matricule;
    private int NombrePlace;
    private Date dateSOrtie;
    private Date DateMisEnMarche;
    private Date DateAchat;
    private VehiculeSatus status;
    private vehiculeEtats Etats;
    @ManyToOne
    private Marque marque;
}
