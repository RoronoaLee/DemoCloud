package com.test.http;

import com.utils.HttpClientFactory;
import com.utils.HttpMethod;
import com.utils.SSLClient;
import org.apache.http.HttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import javax.swing.text.html.parser.Entity;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;

public class TestHttp {


    public static void main(String[] args) throws Exception {

//        CloseableHttpClient hc = (CloseableHttpClient) HttpClientFactory.getHttpsClientWithoutAuth();
        CloseableHttpClient hc = (CloseableHttpClient) new SSLClient();
        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("Accept", "application/json");
        map.put("Content-Type", "application/json");
//        map.put("x-ms-principal-id", "user02");

        HttpEntity entity = HttpMethod.httpsGet(hc, "https://106.14.146.79/", map,
                "106.14.146.79", 80);

        try {
            InputStream inSm = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(inSm,
                    "UTF-8"));
            String data = "";
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }
        } catch (Exception e) {

        }


    }
}
