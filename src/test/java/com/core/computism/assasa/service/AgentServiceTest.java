package com.core.computism.assasa.service;


import com.core.computism.assasa.BaseUnitTest;
import com.core.computism.assasa.persistence.entity.ticket.Agent;
import com.core.computism.assasa.persistence.repository.ticket.AgentRepository;
import com.core.computism.assasa.service.impl.AgentServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by Venturedive on 11/26/2015.
 */
public class AgentServiceTest extends BaseUnitTest {

    @Mock private AgentRepository agentRepository;

    @InjectMocks
    private AgentService agentService = new AgentServiceImpl();

    @Test
    public void testGetSystemAgent() {
        Agent expected = getMockAgent();
        doReturn(expected).when(agentRepository).findByFirstNameAndLastName(anyString(), anyString());

        Agent actual = agentService.getSystemAgent();
        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
        verify(agentRepository, times(1)).findByFirstNameAndLastName(anyString(), anyString());

        Agent agent = agentService.getSystemAgent();
        assertThat(agent, notNullValue());
        assertThat(agent, is(actual));
        verifyNoMoreInteractions(agentRepository);
    }

    private Agent getMockAgent() {
        Agent agent = new Agent();
        agent.setId(11L);
        agent.setFirstName("TEST");
        agent.setLastName("SYSTEM");
        return agent;
    }
}
