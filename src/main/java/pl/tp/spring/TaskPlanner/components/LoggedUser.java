package pl.tp.spring.TaskPlanner.components;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.tp.spring.TaskPlanner.dto.UserDto;
import pl.tp.spring.TaskPlanner.services.UserService;

@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoggedUser {

    private UserService userService;
    private UserDto userDto;

    public LoggedUser(UserService userService) {
        this.userService = userService;
    }
    public UserDto value() {
        if(userDto == null) {
            this.userDto = userService.getLoggedUser();
        }
        return userDto;
    }
}
