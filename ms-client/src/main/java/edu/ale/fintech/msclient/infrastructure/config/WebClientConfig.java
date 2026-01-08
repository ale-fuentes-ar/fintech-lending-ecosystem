package edu.ale.fintech.msclient.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {

    @Value("${services.ms-score.url}")
    private String msScoreUrl;
    
    @Bean
    public WebClient scoreWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl(msScoreUrl)
                .build();
    }

}
