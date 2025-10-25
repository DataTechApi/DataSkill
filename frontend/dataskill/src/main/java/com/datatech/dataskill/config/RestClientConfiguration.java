package com.datatech.dataskill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RestClientConfiguration {
     @Bean
    public RestClient myRestClient() {
        return RestClient.builder()
                // You can customize the RestClient here, e.g.,
                // .baseUrl("http://example.com/api")
                // .defaultHeader("Authorization", "Bearer your_token")
                // .build();
                .build();
    }

}
