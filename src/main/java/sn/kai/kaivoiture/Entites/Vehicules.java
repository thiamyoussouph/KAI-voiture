package sn.kai.kaivoiture.Entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.kai.kaivoiture.enums.VehiculeSatus;
import sn.kai.kaivoiture.enums.vehiculeEtats;

import javax.persistence.*;
import java.util.Collection;
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
    @Enumerated(EnumType.STRING)
    private VehiculeSatus status;
    @Enumerated(EnumType.STRING)
    private vehiculeEtats Etats;
    @ManyToOne
    private Modele modele;
}
