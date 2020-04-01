package pl.tp.spring.TaskPlanner.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.tp.spring.TaskPlanner.domain.model.Job;
import pl.tp.spring.TaskPlanner.domain.model.Localization;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


public interface LocalizationRepository extends JpaRepository<Localization, Long> {


}
