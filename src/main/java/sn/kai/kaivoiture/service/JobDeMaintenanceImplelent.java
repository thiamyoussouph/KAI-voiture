package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Dtos.JobDeMaintenanceDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.JobDeMaintenance;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;
import sn.kai.kaivoiture.Mappers.JobDeMaintenanceMapperimplement;
import sn.kai.kaivoiture.Repository.JobDeMaintenanceRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class JobDeMaintenanceImplelent implements IJobDeMaintenanceService {

  private   JobDeMaintenanceRepository jobDeMaintenanceRepository;
   private JobDeMaintenanceMapperimplement jobDeMaintenanceMapperimplement;

    @Override
    public JobDeMaintenanceDto saveJobDeMaintenance(JobDeMaintenanceDto jobDeMaintenanceDto) {
        JobDeMaintenance jobDeMaintenance=jobDeMaintenanceMapperimplement.fromjobDeMaintenanceDto(jobDeMaintenanceDto);
       JobDeMaintenance jobDeMaintenanc= jobDeMaintenanceRepository.save(jobDeMaintenance);
        return jobDeMaintenanceMapperimplement.fromjobDeMaintenance(jobDeMaintenanc);
    }

    @Override
    public JobDeMaintenanceDto updateJobDeMaintenance(JobDeMaintenanceDto jobDeMaintenanceDto) {
        JobDeMaintenance jobDeMaintenance=jobDeMaintenanceMapperimplement.fromjobDeMaintenanceDto(jobDeMaintenanceDto);
        JobDeMaintenance jobDeMaintenanc= jobDeMaintenanceRepository.save(jobDeMaintenance);
        return jobDeMaintenanceMapperimplement.fromjobDeMaintenance(jobDeMaintenanc);
    }

    @Override
    public void deleteJobDeMaintenance(Integer id) {
        jobDeMaintenanceRepository.deleteById(id);

    }

    @Override
    public JobDeMaintenanceDto findById(Integer id) throws VehiculeExceptionEdite {
        JobDeMaintenance jobDeMaintenance=jobDeMaintenanceRepository.findById(id).orElse(null);
        if (jobDeMaintenance==null){
            throw new VehiculeExceptionEdite("jobDeMaintenance introuvable");
        }
        jobDeMaintenanceRepository.findById(id);
        return jobDeMaintenanceMapperimplement.fromjobDeMaintenance(jobDeMaintenance);

    }

    @Override
    public Collection<JobDeMaintenanceDto> findAll() {
        Collection<JobDeMaintenance> jobDeMaintenances=jobDeMaintenanceRepository.findAll();
        Collection<JobDeMaintenanceDto> jobDeMaintenanceDtos=jobDeMaintenances.stream().map(jobDeMaintenance -> jobDeMaintenanceMapperimplement.fromjobDeMaintenance(jobDeMaintenance)).collect(Collectors.toList());
        return jobDeMaintenanceDtos;
}
}

