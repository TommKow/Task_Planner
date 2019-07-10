package pl.tp.spring.TaskPlanner.services.impl;

import org.springframework.stereotype.Service;
import pl.tp.spring.TaskPlanner.domain.model.JobPlanner;
import pl.tp.spring.TaskPlanner.domain.model.Team;
import pl.tp.spring.TaskPlanner.dto.TeamDto;
import pl.tp.spring.TaskPlanner.repository.TeamRepository;
import pl.tp.spring.TaskPlanner.services.TeamService;
import pl.tp.spring.TaskPlanner.services.converters.ConverterFactory;

import java.util.List;
import java.util.Set;

@Service
public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team saveTeam(TeamDto teamDto) {
        Team teamToSave = ConverterFactory.convertTeamDto(teamDto);
        teamRepository.save(teamToSave);
        return teamToSave;
    }

    @Override
    public void editTeam(Long id, TeamDto teamDto) {
        Team teamDB = teamRepository.getOne(id);
        Team teamToEdit = ConverterFactory.convertToTeamDto(teamDB, teamDto);
        teamRepository.save(teamToEdit);
    }

    @Override
    public void deleteTeam(Long id) {
            Team teamDB = teamRepository.getOne(id);

            teamDB.setJobPlanners(null);
            teamRepository.delete(teamDB);

    }
}
