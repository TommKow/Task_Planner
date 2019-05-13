package pl.tp.spring.TaskPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.tp.spring.TaskPlanner.domain.model.Job;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    @Query(value = "SELECT j " +
            "from Job j " +
            "join JobPlanner jp on j.id = jp.job.id " +
            "join Localization l on l.id = jp.localizations.id " +
            "where l.id = :id")
    List<Job> findLocalizationByNameAndJobWithin(@Param("id") Long id);
}
