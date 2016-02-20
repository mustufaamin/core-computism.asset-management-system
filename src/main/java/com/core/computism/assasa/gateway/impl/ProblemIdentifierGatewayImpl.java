package com.core.computism.assasa.gateway.impl;

import com.core.computism.assasa.config.ApplicationProperties;
import com.core.computism.assasa.domain.IssueDTO;
import com.core.computism.assasa.gateway.ProblemIdentifierGateway;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Venturedive on 9/10/2015.
 */
@Service(value = "problemIdentifierGateway")
public class ProblemIdentifierGatewayImpl implements ProblemIdentifierGateway {

    private static final Logger LOGGER = Logger.getLogger(AmazonSQSGatewayImpl.class);

    @Autowired
    protected ApplicationProperties applicationProperties;

    @Override
    public List<IssueDTO> verifyIssues(List<IssueDTO> issues) {
        String url = applicationProperties.getTicketVerificationUrl();
        LOGGER.info("Requesting Problem Identifier Gateway for Ticket Verification [" + url + "]");

        HttpEntity<List<IssueDTO>> request = createRequest(issues);
        return sendRequest(url, request, HttpMethod.POST);
    }

    private List<IssueDTO> sendRequest(String url, HttpEntity<List<IssueDTO>> request, HttpMethod method) {
        try {
            ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
            RestTemplate restTemplate = new RestTemplate(requestFactory);

            ParameterizedTypeReference<List<IssueDTO>> responseType = new ParameterizedTypeReference<List<IssueDTO>>() {};
            ResponseEntity<List<IssueDTO>> apiResponse = restTemplate.exchange(url, method, request, responseType);

            LOGGER.debug("Interface [" + url + "], Request [" + request.getBody() + "], Response ["
                    + apiResponse.getStatusCode().name() + " / " + apiResponse.getBody() + "]");

            return apiResponse.getBody();

        } catch (HttpClientErrorException e) {
            LOGGER.error("Error sending request to Interface [" + url + "], Method [" + method + "], Request ["
                    + request.getBody() + "]", e);

        } catch(Exception e) {
            LOGGER.error("Error sending request to Interface [" + url + "], Method [" + method + "]", e);
        }
        return null;
    }

    private HttpEntity<List<IssueDTO>> createRequest(List<IssueDTO> dataList) {
        return new HttpEntity<List<IssueDTO>>(dataList, getRequestHeader());
    }

    private HttpHeaders getRequestHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
