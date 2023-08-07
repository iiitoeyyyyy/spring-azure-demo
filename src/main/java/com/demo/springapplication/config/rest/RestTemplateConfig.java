package com.demo.springapplication.config.rest;

import com.demo.springapplication.library.auditlog.config.TrustCertificationConfig;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.X509TrustManager;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@Configuration
public class RestTemplateConfig {
    @Value("${custom.rest.connection.default-max-idle-connections:50}")
    private int maxIdleConnections;
    @Value("${custom.rest.connection.default-keep-alive-duration:60000}")
    private int keepAliveDuration;
    @Value("${custom.rest.connection.connect-timeout:5000}")
    private int connectTimeout;
    @Value("${custom.rest.connection.read-timeout:24000}")
    private int readTimeout;
    @Value("${custom.rest.connection.connection-request-timeout:5000}")
    private int requestTimeout;

    /**
     * Default REST Template for connection to internal microservice
     */
    @Bean(name = "internalRestTemplate")
    public RestTemplate getInternalRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        ConnectionPool okHttpConnectionPool = new ConnectionPool(maxIdleConnections, keepAliveDuration, TimeUnit.MILLISECONDS);
        builder.connectionPool(okHttpConnectionPool);
        builder.connectTimeout(connectTimeout, TimeUnit.MILLISECONDS);
        builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
        builder.writeTimeout(requestTimeout, TimeUnit.MILLISECONDS);
        builder.retryOnConnectionFailure(false);

        restTemplate.setRequestFactory(new OkHttp3ClientHttpRequestFactory(builder.sslSocketFactory(TrustCertificationConfig.trustAllSslSocketFactory, (X509TrustManager) TrustCertificationConfig.trustAllCerts[0]).build()));
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        return restTemplate;
    }

}
