package com.nhom1.java6.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.nimbusds.jose.Header;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class SecurityResttemplate {
    RestTemplate client = new RestTemplate();

    public JsonNode get(String url){
        return this.request(url, HttpMethod.GET,null);
    }

    public JsonNode post(String url, Object data){
        return this.request(url, HttpMethod.POST,data);
    }

    public JsonNode put(String url, Object data){
        return this.request(url, HttpMethod.PUT,data);
    }

    public JsonNode delete(String url){
        return this.request(url, HttpMethod.DELETE,null);
    }

    private JsonNode request(String url,HttpMethod method,Object data){
        // 1 Headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic YWRtaW46MTIz");
        //2 Data
        HttpEntity<Object> entity = new HttpEntity<>(data,headers);
        //3 Request & Response
        ResponseEntity<JsonNode> response = client.exchange(url,method,entity,JsonNode.class);
        return response.getBody();
    }

}
