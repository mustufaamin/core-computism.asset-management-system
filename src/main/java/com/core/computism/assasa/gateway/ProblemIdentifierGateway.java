package com.core.computism.assasa.gateway;

import com.core.computism.assasa.domain.IssueDTO;

import java.util.List;

/**
 * Created by Venturedive on 9/10/2015.
 */
public interface ProblemIdentifierGateway {

    public List<IssueDTO> verifyIssues(List<IssueDTO> issues);
}
