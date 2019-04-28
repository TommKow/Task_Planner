package pl.tp.spring.TaskPlanner.services.impl;

import org.springframework.stereotype.Service;
import pl.tp.spring.TaskPlanner.domain.model.Team;
import pl.tp.spring.TaskPlanner.dto.TeamDto;
import pl.tp.spring.TaskPlanner.repository.TeamRepository;
import pl.tp.spring.TaskPlanner.services.TeamService;
import pl.tp.spring.TaskPlanner.services.converters.ConverterFactory;

@Service
public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void saveTeam(TeamDto teamDto) {
        Team teamToSave = ConverterFactory.convertTeamDto(teamDto);
        teamRepository.save(teamToSave);
    }

    @Override
    public void editTeam(Long id, TeamDto teamDto) {
        Team teamDB = teamRepository.getOne(id);
        Team teamToEdit = ConverterFactory.convertToTeamDto(teamDB, teamDto);
        teamRepository.save(teamToEdit);
    }

    @Override
    public void deleteTeam(Long id, TeamDto teamDto) {
        Team teamDB = teamRepository.getOne(id);
        Team teamToEdit = ConverterFactory.convertToTeamDto(teamDB, teamDto);
        teamRepository.delete(teamToEdit);
    }
}
