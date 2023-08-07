package com.demo.springapplication.controller;

import com.demo.springapplication.library.common.model.mb.ResponseModel;
import com.demo.springapplication.library.logger.AzureLoggerComponent;
import com.demo.springapplication.library.logger.SampleLogFormat;
import com.demo.springapplication.model.SvcModel;
import com.demo.springapplication.service.SvcService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private AzureLoggerComponent azureLoggerComponent;

    @Autowired
    private ObjectMapper objMapper;

    @Autowired
    private SvcService svcService;

    @Autowired
    HttpHeaders httpHeaders;

    @RequestMapping(method = RequestMethod.POST, path = "/payload", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String index(@RequestBody String jsonPaylod) throws JsonProcessingException {
        SampleLogFormat s = new SampleLogFormat("Muthu", jsonPaylod);
        azureLoggerComponent.pushLogsToAzure(objMapper.writeValueAsString(s));
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/v1/svc")
    public String mbLayerController(
            @RequestBody SvcModel svcModel
    ) throws JsonProcessingException {
        SampleLogFormat s = new SampleLogFormat("mb-layer", svcModel.getName());
        ResponseModel<SvcModel> response = svcService.svcServiceApi(svcModel);
        azureLoggerComponent.pushLogsToAzure(objMapper.writeValueAsString(s));
        return response.getDataObj().getName();
    }
}