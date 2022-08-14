package sn.kai.kaivoiture.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class KilometrageVehicule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long kilometrage;
    private Date dateEnregistrement;
    @ManyToOne
    Vehicules vehicules;
}
