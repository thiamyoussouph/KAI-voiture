package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Dtos.JobDeMaintenanceDto;
import sn.kai.kaivoiture.Exception.MarquenotFondException;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;
import sn.kai.kaivoiture.Mappers.JobDeMaintenanceMapperimplement;
import sn.kai.kaivoiture.service.JobDeMaintenanceImplelent;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class JobDeMaintenanceController {
  @Autowired
     private JobDeMaintenanceImplelent jobDeMaintenanceImplelent;
        @GetMapping("/jobDeMaintenances")
    public Collection<JobDeMaintenanceDto> getjapmaintenace(){

               return jobDeMaintenanceImplelent.findAll();
        }

        @PostMapping ("/savejobmaintenance")
        public JobDeMaintenanceDto ajoutjobDeMaintenance(@RequestBody JobDeMaintenanceDto jobDeMaintenanceDto) throws MarquenotFondException {

            return jobDeMaintenanceImplelent.saveJobDeMaintenance(jobDeMaintenanceDto);
        }
        @PutMapping("/updatejobmaintenance/{id}")
        public JobDeMaintenanceDto updatejobDeMaintenance(@PathVariable(value = "id")int id,@RequestBody JobDeMaintenanceDto jobDeMaintenanceDto) throws MarquenotFondException {
            jobDeMaintenanceDto.setId(id);
            return   jobDeMaintenanceImplelent.updateJobDeMaintenance(jobDeMaintenanceDto);
        }
        @GetMapping("/editerjobmaintenance/{id}")
        public JobDeMaintenanceDto editejobDeMaintenance(@PathVariable(value = "id")int id) throws MarquenotFondException, VehiculeExceptionEdite {
            return jobDeMaintenanceImplelent.findById(id);
        }
        @DeleteMapping("/suprimerjobmaintenance/{id}")
        public void suprsionjobDeMaintenance(@PathVariable(value = "id") int id){
            jobDeMaintenanceImplelent.deleteJobDeMaintenance(id);
        }
}
