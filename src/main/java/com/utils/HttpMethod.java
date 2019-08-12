package com.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpMethod {
    public static void main(String[] args) {


    }

    public static HttpEntity httpsGet(CloseableHttpClient httpClient, String url, HashMap<String,
            String> hashMap) throws ClientProtocolException, IOException {

        HttpEntity entity = null;
        HttpGet httpGet = new HttpGet(url);

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            httpGet.setHeader(entry.getKey(), entry.getValue());
        }

        HttpHost target = new HttpHost("106.14.146.79", 80, "https");
        CloseableHttpResponse response = httpClient.execute(target, httpGet);

        try {
            entity = response.getEntity();
        } finally {
            response.close();
        }

        return entity;
    }

    public static HttpEntity httpsGetNTLM(CloseableHttpClient httpClient, String url, HashMap<String,
            String> hashMap) throws ClientProtocolException, IOException {

        HttpEntity entity = null;
        HttpGet httpGet = new HttpGet(url);

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            httpGet.setHeader(entry.getKey(), entry.getValue());
        }

        HttpHost target = new HttpHost("106.14.146.79", 80, "https");
        CloseableHttpResponse response = httpClient.execute(target, httpGet);

        try {
            entity = response.getEntity();
        } finally {
            response.close();
        }

        return entity;
    }


    public stait c
}
