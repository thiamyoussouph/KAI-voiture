package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sn.kai.kaivoiture.Entites.Marque;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Repository.MarqueReposirory;
import sn.kai.kaivoiture.service.MarqueImplement;
import sn.kai.kaivoiture.service.VehiculeImplemente;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class MarqueController {
private MarqueImplement marqueImplement;
private MarqueReposirory marqueReposirory;
    @GetMapping("/affiche/marque")
    public Collection<Marque> Marque(){

        return marqueImplement.ListeMarque();

    }

    @GetMapping("/affiche/marque/{id}")
    public Marque getMarque(@PathVariable Integer id){

        return marqueReposirory.findById(id).orElse(null);

    }
}
