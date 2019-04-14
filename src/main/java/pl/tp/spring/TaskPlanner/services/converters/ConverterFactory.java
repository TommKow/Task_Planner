package pl.tp.spring.TaskPlanner.services.converters;

import pl.tp.spring.TaskPlanner.domain.model.User;
import pl.tp.spring.TaskPlanner.dto.RegistrationFormDto;

public class ConverterFactory {

    public static User convertUser(RegistrationFormDto registrationFormDto) {
        User user = new User();
        user.setFirstName(registrationFormDto.getFirstName());
        user.setLastName(registrationFormDto.getLastName());
        user.setUsername(registrationFormDto.getFirstName());
        user.setPassword(registrationFormDto.getPassword());
        return user;
    }
}
