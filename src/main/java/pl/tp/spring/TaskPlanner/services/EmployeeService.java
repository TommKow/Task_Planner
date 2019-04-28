package pl.tp.spring.TaskPlanner.services;

import pl.tp.spring.TaskPlanner.domain.model.Employee;
import pl.tp.spring.TaskPlanner.dto.EmployeeDto;

public interface EmployeeService {

    void saveEmployee(EmployeeDto employeeDto);

    void editEmployee(Long id, EmployeeDto employeeDto);
}
