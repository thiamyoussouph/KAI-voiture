package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Entites.PannesVehicule;
import sn.kai.kaivoiture.service.PanneVehiculeImplement;


import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class PanneVeiculeController {
    private PanneVehiculeImplement panneVehiculeImplement;
    @GetMapping("/panneenregistrer")
    public Collection<PannesVehicule> pannesVehicules(){

        return panneVehiculeImplement.findall();

    }
    @PostMapping("/creerpannes")
    public PannesVehicule ajoutvehicules(@RequestBody PannesVehicule pannesVehicule){

        return panneVehiculeImplement.savepannevehicule(pannesVehicule);
    }
    
}
