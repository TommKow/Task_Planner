package pl.tp.spring.TaskPlanner.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tp.spring.TaskPlanner.domain.model.Localization;
import pl.tp.spring.TaskPlanner.dto.LocalizationDto;
import pl.tp.spring.TaskPlanner.repository.LocalizationRepository;
import pl.tp.spring.TaskPlanner.services.LocalizationService;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/localization")
public class LocalizationController {
    private LocalizationRepository localizationRepository;
    private LocalizationService localizationService;

    public LocalizationController(LocalizationRepository localizationRepository, LocalizationService localizationService) {
        this.localizationRepository = localizationRepository;
        this.localizationService = localizationService;
    }
    @ModelAttribute("localizations")
    public Collection<Localization> localizations() {
        List<Localization> localizations = localizationRepository.findAll();
        return localizations;
    }
    @GetMapping("/all")
    public String allLocalization(Model model){
        model.addAttribute("localizations", localizationRepository.findAll());
        return "allLocalization";
    }
    @GetMapping("/add")
    public String addLocalization(Model model) {
        model.addAttribute("localizationDto", new LocalizationDto());
        return "/addLocalization";
    }
    @PostMapping("/add")
    public String addLocalization(@ModelAttribute("localizationDto")LocalizationDto localizationDto, BindingResult result) {
        if(result.hasErrors()) {
            return "addLocalization";
        }
        localizationService.saveLocalization(localizationDto);
        return "redirect:/localization/all";
    }
    @GetMapping("/edit/{id}")
    public String editLocalization(@PathVariable("id")Long id, Model model) {
        model.addAttribute("localizationDto", localizationRepository.getOne(id));
        return "addLocalization";
    }
    @PostMapping("/edit/{id}")
    public String editLocalization(@PathVariable("id")Long id, @ModelAttribute LocalizationDto localizationDto) {
        localizationService.editLocalization(id, localizationDto);
        return "redirect:/localization/all";
    }
    @GetMapping("/delete/{id}")
    public String deleteLocalization(@PathVariable("id")Long id, @ModelAttribute LocalizationDto localizationDto) {
        localizationService.deleteLocalization(id, localizationDto);
        return "redirect:/localization/all";
    }
}
