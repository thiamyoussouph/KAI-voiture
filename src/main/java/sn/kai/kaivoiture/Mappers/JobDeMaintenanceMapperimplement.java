package sn.kai.kaivoiture.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.kai.kaivoiture.Dtos.JobDeMaintenanceDto;
import sn.kai.kaivoiture.Entites.JobDeMaintenance;

@Service
public class JobDeMaintenanceMapperimplement {
    public JobDeMaintenanceDto fromjobDeMaintenance(JobDeMaintenance jobDeMaintenance){
        JobDeMaintenanceDto jobDeMaintenanceDto=new JobDeMaintenanceDto();
        BeanUtils.copyProperties(jobDeMaintenance,jobDeMaintenanceDto);
        return jobDeMaintenanceDto;
    }
    public JobDeMaintenance fromjobDeMaintenanceDto(JobDeMaintenanceDto jobDeMaintenanceDto){
       JobDeMaintenance jobDeMaintenance=new JobDeMaintenance() ;
        BeanUtils.copyProperties(jobDeMaintenanceDto,jobDeMaintenance);
        return jobDeMaintenance;
    }
}
