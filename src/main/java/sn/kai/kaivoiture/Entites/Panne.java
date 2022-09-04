package sn.kai.kaivoiture.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Panne extends Incident{

    private String typePanne;

}
