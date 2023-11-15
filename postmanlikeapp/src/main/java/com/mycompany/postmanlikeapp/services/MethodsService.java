package com.mycompany.postmanlikeapp.services;

import com.mycompany.postmanlikeapp.models.RequestData;
import com.mycompany.postmanlikeapp.models.ResponseData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import org.apache.http.HttpEntity;

public class MethodsService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private long startTime = System.currentTimeMillis();

    public ResponseData sendGetRequest(String url) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);

            ResponseData responseData = createResponseData(response);
            return responseData;
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public ResponseData sendPostRequest(String requestData) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            RequestData request = objectMapper.readValue(requestData, RequestData.class);
            HttpPost httpPost = new HttpPost(request.getUrl());
            CloseableHttpResponse response = httpClient.execute(httpPost);

            ResponseData responseData = createResponseData(response);
            return responseData;
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public ResponseData sendPutRequest(String requestData) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            RequestData request = objectMapper.readValue(requestData, RequestData.class);
            HttpPut httpPut = new HttpPut(request.getUrl());
            CloseableHttpResponse response = httpClient.execute(httpPut);

            ResponseData responseData = createResponseData(response);
            return responseData;
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public ResponseData sendDeleteRequest(String url) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpDelete httpDelete = new HttpDelete(url);
            CloseableHttpResponse response = httpClient.execute(httpDelete);
            ResponseData responseData = createResponseData(response);

            return responseData;
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    private ResponseData createResponseData(CloseableHttpResponse response) throws IOException {
        
        long stopTime = System.currentTimeMillis();
        
        int statusCode = response.getStatusLine().getStatusCode();
        Header[] responseHeaders = response.getAllHeaders();
        String responseBody = EntityUtils.toString(response.getEntity());
        String contentType = findContentType(responseHeaders);
        long responseTime = stopTime - startTime;

        ResponseData responseData = new ResponseData();
        responseData.setResponseBody(contentType.equals("application/json") ? formatJson(responseBody) : responseBody);
        responseData.setResponseHeaders(responseHeaders);
        responseData.setResponseStatusCode(statusCode);
        responseData.setResponseTime(responseTime);

        return responseData;
    }

    private String findContentType(Header[] responseHeaders) {
        for (Header header : responseHeaders) {
            if ("Content-Type".equalsIgnoreCase(header.getName())) {
                return header.getValue();
            }
        }
        return null;
    }

    private String formatJson(String json) throws IOException {
        Object jsonResponse = objectMapper.readValue(json, Object.class);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonResponse);
    }
}
