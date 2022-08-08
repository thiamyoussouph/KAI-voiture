package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Entites.Pannes;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Repository.PanneRepository;
import sn.kai.kaivoiture.service.PannesIplement;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")

public class PanneController {

private PannesIplement pannesIplement;
    @PostMapping("/savepanne")
    public Pannes savepanes(@RequestBody Pannes pannes){
        return pannesIplement.savepanne(pannes);
    }
    @GetMapping("/Pannes")
    public Collection<Pannes> panes(){

        return pannesIplement.listPanne();

    }
}
