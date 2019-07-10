package pl.tp.spring.TaskPlanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.tp.spring.TaskPlanner.domain.model.Team;
import pl.tp.spring.TaskPlanner.dto.TeamDto;
import pl.tp.spring.TaskPlanner.repository.TeamRepository;
import pl.tp.spring.TaskPlanner.services.TeamService;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAddTeam_returnNewTeam() {
        when(teamRepository.save(any(Team.class))).thenReturn(true);
        TeamDto teamDto = new TeamDto();
        assertThat(teamService.saveTeam(teamDto), is(true));

        verify(teamRepository).save(any(Team.class));

        verify(teamRepository, times(1)).exists(anyString());
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
