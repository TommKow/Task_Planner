package pl.tp.spring.TaskPlanner.services.impl;

import org.springframework.stereotype.Service;
import pl.tp.spring.TaskPlanner.domain.model.Employee;
import pl.tp.spring.TaskPlanner.dto.EmployeeDto;
import pl.tp.spring.TaskPlanner.repository.EmployeeRepository;
import pl.tp.spring.TaskPlanner.services.EmployeeService;
import pl.tp.spring.TaskPlanner.services.converters.ConverterFactory;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employeeToSave = ConverterFactory.convertEmployeeDto(employeeDto);
        employeeRepository.save(employeeToSave);
    }

    @Override
    public void editEmployee(Long id, EmployeeDto employeeDto) {
        Employee employeeDB = employeeRepository.getOne(id);
        Employee employeeToEdit = ConverterFactory.convertToEmployeeDto(employeeDB, employeeDto);
        employeeRepository.save(employeeToEdit);
    }

    @Override
    public void deleteEmployee(Long id, EmployeeDto employeeDto) {
        Employee employeeDB = employeeRepository.getOne(id);
        Employee employeeToDelete = ConverterFactory.convertToEmployeeDto(employeeDB, employeeDto);
        employeeRepository.delete(employeeToDelete);
    }


}
