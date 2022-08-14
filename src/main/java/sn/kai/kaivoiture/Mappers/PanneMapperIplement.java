package sn.kai.kaivoiture.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.kai.kaivoiture.Dtos.PannesDto;
import sn.kai.kaivoiture.Entites.Pannes;

@Service
public class PanneMapperIplement {

    public PannesDto fromPanne(Pannes pannes){
        PannesDto pannesDto=new PannesDto();
        BeanUtils.copyProperties(pannes,pannesDto);
        return pannesDto;
    }
    public Pannes fromPannesDto(PannesDto pannesDto){
        Pannes pannes=new Pannes();
        BeanUtils.copyProperties(pannesDto,pannes);
        return pannes;
    }
}
