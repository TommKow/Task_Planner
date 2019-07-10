package pl.tp.spring.TaskPlanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.tp.spring.TaskPlanner.domain.model.Team;
import pl.tp.spring.TaskPlanner.dto.TeamDto;
import pl.tp.spring.TaskPlanner.repository.TeamRepository;
import pl.tp.spring.TaskPlanner.services.TeamService;
import pl.tp.spring.TaskPlanner.services.impl.TeamServiceImpl;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamServiceImpl teamService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAddTeam_returnNewTeam() {
        when(teamRepository.save(any(Team.class))).thenReturn(new Team());
        TeamDto teamDto = new TeamDto();
        assertThat(teamService.saveTeam(teamDto), is(notNullValue()));


    }

//    @Test
//    public void testAddTeam_returnsNewTeamWithId() {
//        when(teamRepository.save(any(Team.class))).thenAnswer(new Answer<Team>() {
//
//            @Override
//            public Team answer(InvocationOnMock invocationOnMock) throws Throwable {
//                Object[] arguments = invocationOnMock.getArguments();
//                if(arguments != null && arguments.length > 0 && arguments[0] != null) {
//                    Team team = (Team) arguments[0];
//                    team.setId(1);
//                    return team;
//                }
//                return null;
//            }
//        });
//        TeamDto teamDto = new TeamDto();
//        assertThat(teamService.saveTeam(teamDto), is(notNullValue()));
//    }

}
