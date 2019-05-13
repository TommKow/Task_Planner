package pl.tp.spring.TaskPlanner.services.impl;

import org.springframework.stereotype.Service;
import pl.tp.spring.TaskPlanner.domain.model.Localization;
import pl.tp.spring.TaskPlanner.dto.LocalizationDto;
import pl.tp.spring.TaskPlanner.repository.LocalizationRepository;
import pl.tp.spring.TaskPlanner.services.LocalizationService;
import pl.tp.spring.TaskPlanner.services.converters.ConverterFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class LocalizationServiceImpl implements LocalizationService {
    private LocalizationRepository localizationRepository;


    public LocalizationServiceImpl(LocalizationRepository localizationRepository) {
        this.localizationRepository = localizationRepository;
    }


    @Override
    public void saveLocalization(LocalizationDto localizationDto) {
        Localization localizationToSave = ConverterFactory.convertLocalizationDto(localizationDto);
        localizationRepository.save(localizationToSave);
    }

    @Override
    public void editLocalization(Long id, LocalizationDto localizationDto) {
        Localization localizationDB = localizationRepository.getOne(id);
        Localization localizationToEdit = ConverterFactory.convertToLocalizationDto(localizationDB, localizationDto);
        localizationRepository.save(localizationToEdit);
    }

    @Override
    public void deleteLocalization(Long id, LocalizationDto localizationDto) {
        Localization localizationDB = localizationRepository.getOne(id);
        Localization localizationToDelete = ConverterFactory.convertToLocalizationDto(localizationDB, localizationDto);
        localizationRepository.delete(localizationToDelete);
    }


}
