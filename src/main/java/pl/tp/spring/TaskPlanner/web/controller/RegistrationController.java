package pl.tp.spring.TaskPlanner.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tp.spring.TaskPlanner.dto.RegistrationFormDto;
import pl.tp.spring.TaskPlanner.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model) {
        model.addAttribute("registrationForm", new RegistrationFormDto());
        return "registration";
    }
    @PostMapping
    public String procesRegistrationPage(@Valid @ModelAttribute("registrationForm") RegistrationFormDto registrationFormDto, BindingResult result) {
        if(result.hasErrors()) {
            return "registration";
        }
        boolean usernameFree = userService.isUsernameFree(registrationFormDto.getUsername());
        if(!usernameFree) {
            result.rejectValue("username", null, "Username is taken !!!");
            return "registration";
        }
        userService.registerUser(registrationFormDto);
        return "redirect:/login";
    }
}
