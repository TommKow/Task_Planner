package pl.tp.spring.TaskPlanner.services.impl;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.tp.spring.TaskPlanner.domain.model.User;
import pl.tp.spring.TaskPlanner.dto.RegistrationFormDto;
import pl.tp.spring.TaskPlanner.dto.UserDto;
import pl.tp.spring.TaskPlanner.repository.UserRepository;
import pl.tp.spring.TaskPlanner.services.UserService;
import pl.tp.spring.TaskPlanner.services.converters.ConverterFactory;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean isUsernameFree(String username) {
        return userRepository.isUsernameFree(username);
    }

    @Override
    public void registerUser(RegistrationFormDto registrationFormDto) {
        User userToRegister = ConverterFactory.convertUser(registrationFormDto);
        userToRegister.setPassword(passwordEncoder.encode(userToRegister.getPassword()));
        userRepository.save(userToRegister);
    }

    @Override
    public UserDto getLoggedUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            org.springframework.security.core.userdetails.User securityUser = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
            String username = securityUser.getUsername();
            User userEntity = userRepository.findByUsername(username);
            return ConverterFactory.convertUserDTO(userEntity);
        }
        return null;
    }
}
