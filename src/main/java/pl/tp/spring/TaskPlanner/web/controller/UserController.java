package pl.tp.spring.TaskPlanner.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tp.spring.TaskPlanner.components.LoggedUser;
import pl.tp.spring.TaskPlanner.domain.model.User;
import pl.tp.spring.TaskPlanner.dto.UserDto;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private LoggedUser loggedUser;

    public UserController(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }
    @GetMapping
    public ResponseEntity<String> currentUser(Model model) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            String anonymousUser = (String) authentication.getPrincipal();
            return ResponseEntity.ok(anonymousUser);
        }
        else {
            User user = (User) authentication.getPrincipal();
            model.addAttribute("currentUser", user);
            return ResponseEntity.ok(user.toString());
        }
    }

    @GetMapping("/routing")
    public String afterLoginRouting(@ModelAttribute("userLog")User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                return "redirect:/user/admin";
            }
        }
        return "redirect:/user/logged";
    }

    @GetMapping("/admin")
    public String adminPanel() {
        return "adminPanel";
    }
    @GetMapping("/logged")
    public String loggedUser(Model model, Principal principal) {
        String loggedUser = principal.getName();
        model.addAttribute("loggedUser", loggedUser);
        return "userPanel";
    }

}
