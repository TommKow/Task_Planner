package pl.tp.spring.TaskPlanner.services.impl;

import org.springframework.stereotype.Service;
import pl.tp.spring.TaskPlanner.domain.model.Job;
import pl.tp.spring.TaskPlanner.dto.JobDto;
import pl.tp.spring.TaskPlanner.repository.JobRepository;
import pl.tp.spring.TaskPlanner.services.JobService;
import pl.tp.spring.TaskPlanner.services.converters.ConverterFactory;

@Service
public class JobServiceImpl implements JobService {
    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public void saveJob(JobDto jobDto) {
        Job jobToSave = ConverterFactory.convertJobDto(jobDto);
        jobRepository.save(jobToSave);
    }

    @Override
    public void editJob(Long id, JobDto jobDto) {
        Job jobDB = jobRepository.getOne(id);
        Job jobToEdit = ConverterFactory.convertToJobDto(jobDB, jobDto);
        jobRepository.save(jobToEdit);
    }

    @Override
    public void deleteJob(Long id, JobDto jobDto) {
        Job jobDB = jobRepository.getOne(id);
        Job jobToDelete = ConverterFactory.convertToJobDto(jobDB, jobDto);
        jobRepository.delete(jobToDelete);
    }
}
