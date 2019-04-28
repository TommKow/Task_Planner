package pl.tp.spring.TaskPlanner.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tp.spring.TaskPlanner.domain.model.Team;
import pl.tp.spring.TaskPlanner.dto.TeamDto;
import pl.tp.spring.TaskPlanner.repository.TeamRepository;
import pl.tp.spring.TaskPlanner.services.TeamService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {

    private TeamRepository teamRepository;
    private TeamService teamService;

    public TeamController(TeamRepository teamRepository, TeamService teamService) {
        this.teamRepository = teamRepository;
        this.teamService = teamService;
    }
    @ModelAttribute("teams")
    public Collection<Team> teams() {
        List<Team> teams = teamRepository.findAll();
        return teams;
    }
    @GetMapping("/all")
    public String allTeam(Model model) {
        model.addAttribute("team", new Team());
        return "allTeam";
    }
    @GetMapping("/add")
    public String addTeam(Model model) {
        model.addAttribute("teamDto", new TeamDto());
        return "addTeam";
    }
    @PostMapping("/add")
    public String addTeam(@ModelAttribute("teamDto") @Valid TeamDto teamDto, BindingResult result) {
        if(result.hasErrors()) {
            return "addTeam";
        }
        teamService.saveTeam(teamDto);
        return "redirect:/team/all";
    }
    @GetMapping("/edit/{id}")
    public String editTeam(@PathVariable("id") Long id, Model model) {
        model.addAttribute("teamDto", teamRepository.getOne(id));
        return "addTeam";
    }
    @PostMapping("/edit/{id}")
    public String editTeam(@PathVariable("id") Long id, @ModelAttribute("teamDto") TeamDto teamDto) {
        teamService.editTeam(id, teamDto);
        return "redirect:/team/all";
    }
    @GetMapping("/delete/{id}")
    public String deleteTeam(@PathVariable("id")Long id, @ModelAttribute TeamDto teamDto) {
        teamService.deleteTeam(id, teamDto);
        return "redirect:/team/all";
    }
}
