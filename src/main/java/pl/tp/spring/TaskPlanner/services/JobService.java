package pl.tp.spring.TaskPlanner.services;

import pl.tp.spring.TaskPlanner.dto.JobDto;

public interface JobService {

    void saveJob(JobDto jobDto);
    void editJob(Long id, JobDto jobDto);
    void deleteJob(Long id, JobDto jobDto);
}
