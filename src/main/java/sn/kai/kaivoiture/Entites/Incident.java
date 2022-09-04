package sn.kai.kaivoiture.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class Incident extends Event {
    private String libelle;

}
