package pl.tp.spring.TaskPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.tp.spring.TaskPlanner.domain.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
