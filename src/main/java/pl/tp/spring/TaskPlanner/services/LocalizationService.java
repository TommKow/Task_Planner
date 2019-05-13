package pl.tp.spring.TaskPlanner.services;

import pl.tp.spring.TaskPlanner.domain.model.Localization;
import pl.tp.spring.TaskPlanner.dto.LocalizationDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public interface LocalizationService {

    void saveLocalization(LocalizationDto localizationDto);
    void editLocalization(Long id, LocalizationDto localizationDto);
    void deleteLocalization(Long id, LocalizationDto localizationDto);



}
