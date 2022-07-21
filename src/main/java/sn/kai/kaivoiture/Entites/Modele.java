package sn.kai.kaivoiture.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Modele {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libellet;
    @ManyToOne
    private Marque marque;
    @OneToMany(mappedBy = "modele")
    private Collection<TypesVehicules> typesVehicules;
}
