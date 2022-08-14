package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Dtos.PannesDto;

import sn.kai.kaivoiture.service.PannesIplement;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")

public class PanneController {

private PannesIplement pannesIplement;
    @PostMapping("/savepanne")
    public PannesDto savepanes(@RequestBody PannesDto pannesDto){
        return pannesIplement.savepanne(pannesDto);
    }
    @GetMapping("/Pannes")
    public Collection<PannesDto> panes(){

        return pannesIplement.listPanne();

    }
    @GetMapping("editePanne/{id}")
    public PannesDto edite(@PathVariable(value = "id")int id)  {
        return pannesIplement.findbyid(id);
    }
    @DeleteMapping("/suprimerPannes/{id}")
    public void suprsion(@PathVariable(value = "id") int id){pannesIplement.delete(id);
    }
    @PutMapping("/updatepannes/{id}")
    public PannesDto updatevehicule(@PathVariable(value = "id")int id,@RequestBody PannesDto pannesDto) {
        pannesDto.setId(id);
        return pannesIplement.update(pannesDto);
    }
}
