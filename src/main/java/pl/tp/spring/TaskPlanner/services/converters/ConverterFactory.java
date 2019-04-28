package pl.tp.spring.TaskPlanner.services.converters;

import pl.tp.spring.TaskPlanner.domain.model.Employee;
import pl.tp.spring.TaskPlanner.domain.model.User;
import pl.tp.spring.TaskPlanner.dto.EmployeeDto;
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
    public static Employee convertEmployeeDto(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setAddress(employeeDto.getAddress());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setSalaryPm(employeeDto.getSalaryPm());
        return employee;
    }
    public static Employee convertToEmployeeDto(Employee employeeBase, EmployeeDto employeeDto) {
        employeeBase.setFirstName(employeeDto.getFirstName());
        employeeBase.setLastName(employeeDto.getLastName());
        employeeBase.setAddress(employeeDto.getAddress());
        employeeBase.setPhoneNumber(employeeDto.getPhoneNumber());
        employeeBase.setSalaryPm(employeeDto.getSalaryPm());
        return employeeBase;
    }
}
