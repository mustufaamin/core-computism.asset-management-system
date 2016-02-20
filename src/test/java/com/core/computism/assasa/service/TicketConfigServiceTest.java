package com.core.computism.assasa.service;

import com.core.computism.assasa.BaseUnitTest;
import com.core.computism.assasa.persistence.entity.ticket.ProblemType;
import com.core.computism.assasa.persistence.entity.ticket.TicketConfig;
import com.core.computism.assasa.persistence.repository.ticket.TicketConfigRepository;
import com.core.computism.assasa.service.impl.TicketConfigServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Venturedive on 8/25/2015.
 */
public class TicketConfigServiceTest extends BaseUnitTest {

    @Mock
    private TicketConfigRepository repository;

    @InjectMocks
    private TicketConfigService configService = new TicketConfigServiceImpl();

    @Test
    public void testGetDefaultTicketConfig() {
        Long problemTypeId = 1234L;
        String robotName = "Captain Not Assigned - Dubai";
        List<TicketConfig> ticketConfigs = Arrays.asList( getTicketConfigs(problemTypeId) );

        doReturn(ticketConfigs).when(repository).findByProblemTypeAndRobot(eq(problemTypeId), anyList());

        TicketConfig actual = configService.findByProblemTypeAndRobot(problemTypeId, robotName);
        assertNotNull(actual);
        assertThat(actual, samePropertyValuesAs(ticketConfigs.get(0)));

        TicketConfig cachedActual = configService.findByProblemTypeAndRobot(problemTypeId, robotName);
        assertNotNull(cachedActual);
        assertThat(cachedActual, samePropertyValuesAs(actual));

        verify(repository, times(1)).findByProblemTypeAndRobot(eq(problemTypeId), anyList());
    }

    @Test
    public void testGetRobotSpecificTicketConfig() {
        Long problemTypeId = 5678L;
        String robotName = "Captain Not Assigned - Dubai";
        TicketConfig expected = getTicketConfigs(problemTypeId, robotName);
        List<TicketConfig> ticketConfigs = Arrays.asList( getTicketConfigs(problemTypeId), expected );

        doReturn(ticketConfigs).when(repository).findByProblemTypeAndRobot(eq(problemTypeId), anyList());

        TicketConfig actual = configService.findByProblemTypeAndRobot(problemTypeId, robotName);
        assertNotNull(actual);
        assertThat(actual, samePropertyValuesAs(expected));

        TicketConfig cachedActual = configService.findByProblemTypeAndRobot(problemTypeId, robotName);
        assertNotNull(cachedActual);
        assertThat(cachedActual, samePropertyValuesAs(actual));

        verify(repository, times(1)).findByProblemTypeAndRobot(eq(problemTypeId), anyList());
    }

    private TicketConfig getTicketConfigs(Long problemTypeId, String robotName) {
        TicketConfig config = new TicketConfig();
        config.setId(1L);
        config.setRobotName(robotName);
        config.setProblemType( getProblemType(problemTypeId) );
        config.setActionRequired("Test Action");
        config.setAutoExpireMin(30);
        return config;
    }

    private TicketConfig getTicketConfigs(Long problemTypeId) {
        TicketConfig config = new TicketConfig();
        config.setId(2L);
        config.setRobotName("any robot");
        config.setProblemType(getProblemType(problemTypeId));
        config.setActionRequired("Default Action");
        config.setAutoExpireMin(60);
        return config;
    }

    private ProblemType getProblemType(Long problemTypeId) {
        ProblemType problemType = new ProblemType();
        problemType.setId(problemTypeId);
        problemType.setTypeCode("CAPTAIN_NOT_ASSIGNED");
        return problemType;
    }
}
