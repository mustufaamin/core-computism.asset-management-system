package com.core.computism.assetmanagementsystem.gateway;

import com.core.computism.assetmanagementsystem.domain.IssueDTO;

import java.util.List;

/**
 * Created by Venturedive on 9/10/2015.
 */
public interface ProblemIdentifierGateway {

    public List<IssueDTO> verifyIssues(List<IssueDTO> issues);
}
