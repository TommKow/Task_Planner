package pl.tp.spring.TaskPlanner.services.converters;

import pl.tp.spring.TaskPlanner.domain.model.*;
import pl.tp.spring.TaskPlanner.dto.*;

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
    public static Team convertTeamDto(TeamDto teamDto) {
        Team team = new Team();
        team.setName(teamDto.getName());
        return team;
    }
    public static Team convertToTeamDto(Team teamDB, TeamDto teamDto) {
        teamDB.setName(teamDto.getName());
        return teamDB;
    }
    public static Job convertJobDto(JobDto jobDto) {
        Job job = new Job();
        job.setName(jobDto.getName());
        job.setAccount(jobDto.getAccount());
        return job;
    }
    public static Job convertToJobDto(Job jobDB, JobDto jobDto) {
        jobDB.setName(jobDto.getName());
        jobDB.setAccount(jobDto.getAccount());
        return jobDB;
    }
    public static Localization convertLocalizationDto(LocalizationDto localizationDto) {
        Localization localization = new Localization();
        localization.setName(localizationDto.getName());
        localization.setAccount(localizationDto.getAccount());
        return localization;
    }
    public static Localization convertToLocalizationDto(Localization localizationDB, LocalizationDto localizationDto) {
        localizationDB.setName(localizationDto.getName());
        localizationDB.setAccount(localizationDto.getAccount());
        return localizationDB;
    }
}
