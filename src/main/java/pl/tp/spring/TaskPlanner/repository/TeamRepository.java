package pl.tp.spring.TaskPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tp.spring.TaskPlanner.domain.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
