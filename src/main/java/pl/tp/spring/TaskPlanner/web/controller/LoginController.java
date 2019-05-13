package pl.tp.spring.TaskPlanner.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tp.spring.TaskPlanner.components.LoggedUser;
import pl.tp.spring.TaskPlanner.dto.UserDto;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/login")
public class LoginController {
    private LoggedUser loggedUser;

    public LoginController(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }
    @GetMapping
    public String loginUser(Model model) {

        model.addAttribute("userDto", new UserDto());
        return "login";
    }
}
