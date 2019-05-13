package pl.tp.spring.TaskPlanner.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tp.spring.TaskPlanner.domain.model.*;
import pl.tp.spring.TaskPlanner.dto.LocalizationDto;
import pl.tp.spring.TaskPlanner.repository.*;
import pl.tp.spring.TaskPlanner.services.JobPlannerService;
import pl.tp.spring.TaskPlanner.services.LocalizationService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/jobplanner")
public class JobPlannerController {
    private JobPlannerRepository jobPlannerRepository;
    private EmployeeRepository employeeRepository;
    private LocalizationRepository localizationRepository;
    private JobRepository jobRepository;
    private TeamRepository teamRepository;
    private JobPlannerService jobPlannerService;
    private LocalizationService localizationService;

    @Autowired
    public JobPlannerController(JobPlannerRepository jobPlannerRepository, EmployeeRepository employeeRepository,
                                LocalizationRepository localizationRepository, JobRepository jobRepository,
                                TeamRepository teamRepository, JobPlannerService jobPlannerService, LocalizationService localizationService) {
        this.jobPlannerRepository = jobPlannerRepository;
        this.employeeRepository = employeeRepository;
        this.localizationRepository = localizationRepository;
        this.jobRepository = jobRepository;
        this.teamRepository = teamRepository;
        this.jobPlannerService = jobPlannerService;
        this.localizationService = localizationService;
    }

    @ModelAttribute("teams")
    public Collection<Team> teams() {
        List<Team> teams = teamRepository.findAll();
        return teams;
    }
    @GetMapping("/all")
    public String allJobPlanner(Model model) {
        model.addAttribute("jobplanners", jobPlannerRepository.findJobPlannerByCreatedDesc());
        model.addAttribute("jobplanner", new JobPlanner());
        return "allJobPlanner";
    }
    @GetMapping("/all/{id}")
    public String allJobPlanner(@PathVariable("id")Long id, Model model, Team team) {
        model.addAttribute("jobPlanner", new JobPlanner());
        model.addAttribute("jobPlannerByTeam", jobPlannerRepository.findJobPlannerByTeam(id));
        return "allJobPlanner";
    }
    @PostMapping("/all/{id}")
    public String allJobPlanner(@PathVariable("id")Long id, BindingResult result) {
        if(result.hasErrors()) {
            return "allJobPlanner";
        }

        return "redirect:/jobplanner/all";
    }
    @GetMapping("/add")
    public String addJobPlanner(Model model) {
        model.addAttribute("jobPlanner", new JobPlanner());
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("localizations", localizationRepository.findAll());
        model.addAttribute("jobs", jobRepository.findAll());
        model.addAttribute("teamOne", teamRepository.findAll());

        return "addJobPlanner";
    }
    @RequestMapping(path = {"/add"}, method = {RequestMethod.POST, RequestMethod.PUT})
    public String addJobPlanner(@ModelAttribute JobPlanner jobPlanner, BindingResult result) {
        if(result.hasErrors()) {
            return "addJobPlanner";
        }
        jobPlannerRepository.save(jobPlanner);
        return "redirect:/jobplanner/all";
    }
}
