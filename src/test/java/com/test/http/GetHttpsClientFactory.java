package com.test.http;


import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.KeyManagementException;

public class GetHttpsClientFactory {

    public static void main(String[] args) throws KeyStoreException,
    NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException{

        CloseableHttpClient httpClient = (CloseableHttpClient)GetHttpsClientFactory.getHttpsClient();
    }

    private static CloseableHttpClient client;

    public static HttpClient getHttpsClient() throws KeyStoreException,
            NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException {

        if (client != null) {
            return client;
        }
        SSLContext sslcontext = getSSLContext();
        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslcontext,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
//        SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER


        client = HttpClients.custom().setSSLSocketFactory(factory).build();

        return client;
    }

    public static void releaseInstance() {
        client = null;
    }

    private static SSLContext getSSLContext() throws KeyStoreException,
            NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException {

        //around the fact that it will support that certificate
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream instream = new FileInputStream(new File("my.keystore"));
        try {
            //created a keystore and added the certificate to it.
            trustStore.load(instream, "nopassword".toCharArray());
        } finally {
            instream.close();
        }
        //provide a password to decode the keystore,
        return SSLContexts.custom()
                .loadTrustMaterial(trustStore)
                .build();
    }
}
