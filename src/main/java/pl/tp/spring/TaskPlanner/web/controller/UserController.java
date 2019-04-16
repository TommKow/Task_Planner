package pl.tp.spring.TaskPlanner.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tp.spring.TaskPlanner.components.LoggedUser;
import pl.tp.spring.TaskPlanner.domain.model.User;
import pl.tp.spring.TaskPlanner.dto.UserDto;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private LoggedUser loggedUser;

    public UserController(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }
    @GetMapping
    public ResponseEntity<String> currentUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            String anonymousUser = (String) authentication.getPrincipal();
            return ResponseEntity.ok(anonymousUser);
        }
        else {
            User user = (User) authentication.getPrincipal();
            return ResponseEntity.ok(user.toString());
        }
    }
}
