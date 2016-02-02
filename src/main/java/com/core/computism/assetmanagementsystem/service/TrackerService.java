package com.core.computism.assetmanagementsystem.service;

import com.core.computism.assetmanagementsystem.domain.IssueDTO;

import java.util.List;

/**
 * Created by Venturedive on 8/5/2015.
 */
public interface TrackerService {

    void inspect(List<IssueDTO> issues);
}
