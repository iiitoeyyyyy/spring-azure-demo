package com.demo.springapplication.service;

import com.demo.springapplication.library.common.model.mb.ResponseModel;
import com.demo.springapplication.model.SvcModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SvcService {

    @Autowired
    private HttpHeaders headers;

    @Autowired
    @Qualifier(value = "internalRestTemplate")
    private RestTemplate restTemplate;

    @Value("${svc.layer.uri}")
    private String svcLayerUri;

    public ResponseModel<SvcModel> svcServiceApi(SvcModel svcModel){

        HttpHeaders httpHeaders = new HttpHeaders(headers);


        return restTemplate.exchange(
                svcLayerUri,
                HttpMethod.POST,
                new HttpEntity<>(svcModel,httpHeaders),
                new ParameterizedTypeReference<ResponseModel<SvcModel>>() {
                }
        ).getBody();


    }
}
