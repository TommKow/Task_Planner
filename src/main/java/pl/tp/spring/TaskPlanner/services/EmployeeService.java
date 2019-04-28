package pl.tp.spring.TaskPlanner.services;

import pl.tp.spring.TaskPlanner.dto.EmployeeDto;

public interface EmployeeService {

    void saveEmployee(EmployeeDto employeeDto);

    void editEmployee(Long id, EmployeeDto employeeDto);

    void deleteEmployee(Long id, EmployeeDto employeeDto);
}
