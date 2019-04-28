package pl.tp.spring.TaskPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tp.spring.TaskPlanner.domain.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
