package pl.tp.spring.TaskPlanner.services;

import pl.tp.spring.TaskPlanner.domain.model.Team;
import pl.tp.spring.TaskPlanner.dto.TeamDto;

public interface TeamService {

    Team saveTeam(TeamDto teamDto);

    void editTeam(Long id, TeamDto teamDto);

    void deleteTeam(Long id);


}
