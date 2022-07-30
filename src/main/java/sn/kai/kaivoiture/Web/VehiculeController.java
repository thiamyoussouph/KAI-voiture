package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Exception.MarquenotFondException;
import sn.kai.kaivoiture.Exception.VehiculeException;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;
import sn.kai.kaivoiture.service.VehiculeImplemente;

import java.util.Collection;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class VehiculeController {
    @Autowired
    private VehiculeImplemente vehiculeImplemente;
    @GetMapping("/affiche")
public Collection<Vehicules> vehicules(){

    return vehiculeImplemente.listvehicule();

}

    @PostMapping ("/ajout")
    public Vehicules ajoutvehicules(@RequestBody Vehicules vehicules) throws MarquenotFondException {

        return vehiculeImplemente.saveVehicule(vehicules);


    }
@PutMapping("/updateVehicule/{id}")
public Vehicules updatevehicule(@PathVariable(value = "id")int id,@RequestBody Vehicules vehicules) throws VehiculeException {
      return   vehiculeImplemente.update(id,vehicules);
}
@GetMapping("editer/{id}")
public Vehicules edite(@PathVariable(value = "id")int id) throws VehiculeExceptionEdite {
return vehiculeImplemente.edite(id);
}

@DeleteMapping("/suprimer/{id}")
    public void suprsion(@PathVariable(value = "id") int id){
        vehiculeImplemente.deletevehicule(id);
}

}

