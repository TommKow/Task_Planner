package pl.tp.spring.TaskPlanner.services.converters;

import pl.tp.spring.TaskPlanner.domain.model.User;
import pl.tp.spring.TaskPlanner.dto.RegistrationFormDto;
import pl.tp.spring.TaskPlanner.dto.UserDto;

public class ConverterFactory {

    public static User convertUser(RegistrationFormDto registrationFormDto) {
        User user = new User();
        user.setFirstName(registrationFormDto.getFirstName());
        user.setLastName(registrationFormDto.getLastName());
        user.setUsername(registrationFormDto.getUsername());
        user.setPassword(registrationFormDto.getPassword());
        return user;
    }
    public static UserDto convertUserDTO(User userEntity) {
        UserDto userDto = new UserDto();
        userDto.setUsername(userEntity.getUsername());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        return userDto;
    }
}
