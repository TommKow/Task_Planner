package pl.tp.spring.TaskPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.tp.spring.TaskPlanner.domain.model.JobPlanner;
import pl.tp.spring.TaskPlanner.domain.model.Team;

import java.util.List;

public interface JobPlannerRepository extends JpaRepository<JobPlanner, Long> {

    @Query("SELECT j from JobPlanner j where j.team.id = :id order by j.created desc")
    List<JobPlanner> findJobPlannerByTeam(@Param("id")Long id);

    @Query("SELECT j from JobPlanner j order by j.created desc")
    List<JobPlanner> findJobPlannerByCreatedDesc();

    @Query("SELECT sum(jp.workQuantity) " +
            "from JobPlanner jp " +
            "join Localization l on l.id = jp.localizations.id " +
            "where l.id = :id")
    Integer sumWorkQuantityOnLocalization(@Param("id")Long id);
}
