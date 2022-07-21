package sn.kai.kaivoiture.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Marque {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelet;
    @OneToMany(mappedBy = "marque")
    private Collection<Modele>modeles;
    @OneToMany(mappedBy = "marque")
    private Collection<Vehicules>vehicules;

}
