package com.core.computism.assetmanagementsystem.service;

import com.core.computism.assetmanagementsystem.BaseUnitTest;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.ProblemType;
import com.core.computism.assetmanagementsystem.persistence.repository.ticket.ProblemTypeRepository;
import com.core.computism.assetmanagementsystem.service.impl.ProblemTypeServiceImpl;
import org.joda.time.Instant;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.Timestamp;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

/**
 * Created by Venturedive on 8/18/2015.
 */
public class ProblemTypeServiceTest extends BaseUnitTest {

    @Mock
    private ProblemTypeRepository repository;

    @InjectMocks
    private ProblemTypeService problemTypeService = new ProblemTypeServiceImpl();

    @Test
    public void testGetProblemTypeById() {
        Long id = 1L;
        ProblemType problemType = getProblemType();

        doReturn(problemType).when(repository).findOne(id);

        ProblemType actual = problemTypeService.getProblemTypeById(id);
        assertThat(actual, notNullValue());
        verify(repository, times(1)).findOne(id);
    }

    @Test
    public void testGetProblemTypeByCode() {
        String code = "CAPTAIN_NOT_ASSIGNED";
        ProblemType problemType = getProblemType();

        doReturn(problemType).when(repository).findByTypeCode(code);

        ProblemType actual = problemTypeService.getProblemTypeByCode(code);
        assertThat(actual, notNullValue());

        ProblemType anotherActual = problemTypeService.getProblemTypeByCode(code);
        assertThat(anotherActual, notNullValue());
        assertThat(anotherActual, is(actual));

        verify(repository, times(1)).findByTypeCode(code);
    }

    @Test
    public void testIsCriticalProblemType() {
        ProblemType testProblemType = getProblemType();

        boolean result = problemTypeService.isCriticalProblemType(testProblemType);
        assertThat(result, is(true));
    }

    @Test
    public void testIsNotCriticalProblemType() {
        ProblemType testProblemType = getProblemType();
        testProblemType.setTypeCode("CHECK_45_MINS");

        boolean result = problemTypeService.isCriticalProblemType(testProblemType);
        assertThat(result, is(false));
    }

    private ProblemType getProblemType() {
        ProblemType problemType = new ProblemType();
        problemType.setId(1L);
        problemType.setTypeCode("CAPTAIN_NOT_ASSIGNED");
        problemType.setDescr("Captain Not Assigned");
        problemType.setCreationDate(new Timestamp(Instant.now().getMillis()));
        return problemType;
    }
}
