package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Entites.Event;
import sn.kai.kaivoiture.Entites.Panne;
import sn.kai.kaivoiture.service.Eventserviceimplement;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class EventController {
    @Autowired
    private Eventserviceimplement eventserviceimplement;

    @GetMapping("/events")
    public Collection<Event>getevents(){
        return eventserviceimplement.getAll();

    }
    @PostMapping("/savepane")
    public Panne savepane( @RequestBody Panne panne){
        return eventserviceimplement.savpane(panne);
    }
}
