package com.todo.common.config;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    final int SECOND = 1000;

    @Bean(name = "tcpRestTemplate")
    public RestTemplate getClientHttpRequestFactory(){
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
                new HttpComponentsClientHttpRequestFactory();

        clientHttpRequestFactory.setConnectTimeout(3*SECOND);
        clientHttpRequestFactory.setReadTimeout(3*SECOND);
        clientHttpRequestFactory.setHttpClient(HttpClientBuilder.create()
                .setMaxConnTotal(100)
                .build());
        return new RestTemplate(clientHttpRequestFactory);
    }
}
