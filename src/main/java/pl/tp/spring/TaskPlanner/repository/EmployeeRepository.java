package pl.tp.spring.TaskPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.tp.spring.TaskPlanner.domain.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //@Query("SELECT Employee from Employee e where e.id ")

}
