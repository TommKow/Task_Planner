package pl.tp.spring.TaskPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tp.spring.TaskPlanner.domain.model.Localization;

public interface LocalizationRepository extends JpaRepository<Localization, Long> {
}
