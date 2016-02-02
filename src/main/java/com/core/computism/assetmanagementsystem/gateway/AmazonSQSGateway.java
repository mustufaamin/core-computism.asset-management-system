package com.core.computism.assetmanagementsystem.gateway;

import com.core.computism.assetmanagementsystem.domain.IssueDTO;

import java.util.List;

/**
 * Created by Venturedive on 8/10/2015.
 */
public interface AmazonSQSGateway {

    List<IssueDTO> dequeue();
}
