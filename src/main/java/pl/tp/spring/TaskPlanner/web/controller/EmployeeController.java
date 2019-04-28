package pl.tp.spring.TaskPlanner.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tp.spring.TaskPlanner.domain.model.Employee;
import pl.tp.spring.TaskPlanner.dto.EmployeeDto;
import pl.tp.spring.TaskPlanner.repository.EmployeeRepository;
import pl.tp.spring.TaskPlanner.services.EmployeeService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }
    @ModelAttribute("employees")
    public Collection<Employee> employees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }
    @GetMapping("/all")
    public String allEmployee(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("employee", new Employee());
        return "allEmployee";
    }
    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "addEmployee";
    }
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employeeDto") @Valid EmployeeDto employeeDto, BindingResult result) {
        if(result.hasErrors()) {
            return "addEmployee";
        }
        employeeService.saveEmployee(employeeDto);
        return "redirect:/employee/all";
    }
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employeeDto", employeeRepository.findById(id));
        return "addEmployee";
    }
    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") Long id, @ModelAttribute EmployeeDto employeeDto) {
        employeeService.editEmployee(id, employeeDto);
        return "redirect:/employee/all";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id, @ModelAttribute EmployeeDto employeeDto) {
        employeeService.deleteEmployee(id, employeeDto);
        return "redirect:/employee/all";
    }

}
