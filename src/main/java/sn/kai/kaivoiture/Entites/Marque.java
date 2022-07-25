package sn.kai.kaivoiture.Entites;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String libellet;
    @OneToMany(mappedBy = "marque")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Modele>modeles;

}
