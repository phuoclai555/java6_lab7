package com.nhom1.java6.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SecurityRestURL {

    static ObjectMapper mapper = new ObjectMapper();

    public static JsonNode get(String url){
        return request(url, "GET",null);
    }

    public static JsonNode post(String url, Object data){
        return request(url,"POST",data);
    }

    public static JsonNode put(String url, Object data){
        return request(url, "PUT",data);
    }

    public static JsonNode delete(String url){
        return request(url, "DELETE",null);
    }

    private static JsonNode request(String url,String method,Object data){
        HttpURLConnection conn = null;
        try{
            //1 REQUEST
            conn =(HttpURLConnection) new URL(url).openConnection();
            conn.setRequestProperty("Accept","application/json");
            conn.setRequestMethod(method);
            conn.setRequestProperty("Authorization","Basic YWRtaW46MTIz");
            // 2 DATA (POST & PUT only)
            if(data != null){
                conn.setDoOutput(true);
                mapper.writeValue(conn.getOutputStream(),data);
            }

            //3 Processing Response
            int responseCode = conn.getResponseCode();
            if(responseCode == 200){
                return mapper.readTree(conn.getInputStream());
            }
            return null;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
