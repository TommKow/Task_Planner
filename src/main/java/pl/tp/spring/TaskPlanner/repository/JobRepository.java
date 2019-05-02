package pl.tp.spring.TaskPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tp.spring.TaskPlanner.domain.model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}
