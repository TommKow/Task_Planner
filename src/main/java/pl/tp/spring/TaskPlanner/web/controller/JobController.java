package pl.tp.spring.TaskPlanner.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tp.spring.TaskPlanner.domain.model.Job;
import pl.tp.spring.TaskPlanner.dto.JobDto;
import pl.tp.spring.TaskPlanner.repository.JobRepository;
import pl.tp.spring.TaskPlanner.services.JobService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {
    private JobRepository jobRepository;
    private JobService jobService;

    public JobController(JobRepository jobRepository, JobService jobService) {
        this.jobRepository = jobRepository;
        this.jobService = jobService;
    }
    @ModelAttribute("jobs")
    public Collection<Job> jobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs;
    }
    @GetMapping("/all")
    public String allJob(Model model) {
        model.addAttribute("jobs", jobRepository.findAll());
        return "allJob";
    }
    @GetMapping("/add")
    public String addJob(Model model) {
        model.addAttribute("jobDto", new JobDto());
        return "addJob";
    }
    @PostMapping("/add")
    public String addJob(@ModelAttribute("jobDto") @Valid JobDto jobDto, BindingResult result) {
        if(result.hasErrors()) {
            return "addJob";
        }
        jobService.saveJob(jobDto);
        return "redirect:/job/all";
    }
    @GetMapping("/edit/{id}")
    public String editJob(@PathVariable("id")Long id, Model model) {
        model.addAttribute("jobDto", jobRepository.getOne(id));
        return "addJob";
    }
    @PostMapping("/edit/{id}")
    public String editJob(@PathVariable("id")Long id, @ModelAttribute JobDto jobDto) {
        jobService.editJob(id, jobDto);
        return "redirect:/job/all";
    }
    @GetMapping("/delete/{id}")
    public String deleteJob(@PathVariable("id")Long id, @ModelAttribute JobDto jobDto) {
        jobService.deleteJob(id, jobDto);
        return "redirect:/job/all";
    }
}
