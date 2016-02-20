package com.core.computism.assasa.gateway;

import com.core.computism.assasa.domain.IssueDTO;

import java.util.List;

/**
 * Created by Venturedive on 8/10/2015.
 */
public interface AmazonSQSGateway {

    List<IssueDTO> dequeue();
}
