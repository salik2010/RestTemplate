package com.example.resttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import org.springframework.http.HttpHeaders;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpUriRequest;
//import org.apache.http.client.methods.RequestBuilder;
//import org.apache.http.impl.client.HttpClients;



import java.util.Arrays;

@RestController
public class RestControll {

    RestTemplate restTemplate;

    @Autowired
    public RestControll(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @RequestMapping(value = "/template")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);



        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://94.198.50.185:7081/api/users", String.class);


        System.out.println(forEntity.getHeaders().get("Set-Cookie"));
        return restTemplate.exchange("http://94.198.50.185:7081/api/users",
                HttpMethod.GET, entity, String.class).getBody();
    }
}
