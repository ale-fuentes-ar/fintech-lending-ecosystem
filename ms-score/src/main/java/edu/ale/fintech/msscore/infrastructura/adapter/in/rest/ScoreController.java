package edu.ale.fintech.msscore.infrastructura.adapter.in.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ale.fintech.msscore.application.port.in.GetScoreUseCase;
import edu.ale.fintech.msscore.infrastructura.adapter.in.rest.dto.ScoreResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ve/scores")
@RequiredArgsConstructor
public class ScoreController {

    private final GetScoreUseCase getScoreUseCase;

    @GetMapping("/{customerId}")
    public ResponseEntity<ScoreResponse> getScore(@PathVariable String customerId) {
        var score = getScoreUseCase.execute(customerId);

        var response = ScoreResponse.builder()
                .customerId(score.getCustomerId())
                .creditScore(score.getCreditScore())
                .riskLevel(score.getRiskLevel())
                .lastUpdate(score.getLastUpdated())
                .build();

        return ResponseEntity.ok(response);
    }
}
