package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Dtos.JobDeMaintenanceDto;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;

import java.util.Collection;

public interface IJobDeMaintenanceService {
   JobDeMaintenanceDto saveJobDeMaintenance(JobDeMaintenanceDto jobDeMaintenanceDto);
    JobDeMaintenanceDto updateJobDeMaintenance(JobDeMaintenanceDto jobDeMaintenanceDto);
    public void deleteJobDeMaintenance(Integer id);
     JobDeMaintenanceDto findById(Integer id) throws VehiculeExceptionEdite;
    public Collection<JobDeMaintenanceDto> findAll();
}
