package edu.ale.fintech.msclient.infrastructure.adapter.out.external;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import edu.ale.fintech.msclient.application.port.out.ScoreClientPort;
import edu.ale.fintech.msclient.infrastructure.adapter.out.external.dto.ScoreExternalResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScoreWebClientAdapter implements ScoreClientPort {

    private final WebClient scoreWebClient;

    @Override
    @CircuitBreaker(name = "scoreService", fallbackMethod = "fetchScoreFallback")
    public Optional<ScoreExternalResponse> fetchScore(String dni) {
        ScoreExternalResponse response = scoreWebClient.get()
                .uri("/api/v1/scores/{customerId}", dni)
                .retrieve()
                .bodyToMono(ScoreExternalResponse.class)
                .block();

        return Optional.ofNullable(response);

    }

    public Optional<ScoreExternalResponse> fetchScoreFallback(String dni, Throwable throwable) {
        log.error("Circuit Breaker activado para DNI {}. Razón: {}", dni, throwable.getMessage());
        return Optional.empty();
    }
}
