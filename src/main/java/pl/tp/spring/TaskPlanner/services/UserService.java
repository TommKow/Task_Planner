package pl.tp.spring.TaskPlanner.services;

import pl.tp.spring.TaskPlanner.dto.RegistrationFormDto;

public interface UserService {

    boolean isUsernameFree(String name);

    void registerUser(RegistrationFormDto registrationFormDto);
}
