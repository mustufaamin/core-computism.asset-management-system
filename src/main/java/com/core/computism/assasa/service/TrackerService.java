package com.core.computism.assasa.service;

import com.core.computism.assasa.domain.IssueDTO;

import java.util.List;

/**
 * Created by Venturedive on 8/5/2015.
 */
public interface TrackerService {

    void inspect(List<IssueDTO> issues);
}
