package edu.ale.fintech.msscore.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import edu.ale.fintech.msscore.application.port.in.GetScoreUseCase;
import edu.ale.fintech.msscore.application.port.out.ScoreRepositoryPort;
import edu.ale.fintech.msscore.domain.model.RiskLevel;
import edu.ale.fintech.msscore.domain.model.Score;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScoreService implements GetScoreUseCase {

    private final ScoreRepositoryPort scoreRepositoryPort;

    @Override
    public Score execute(String customerId) {

        return scoreRepositoryPort.findByCustomerId(customerId)
                .orElseGet(() -> {
                    Score newScore = Score.builder()
                            .customerId(customerId)
                            .creditScore(600)
                            .riskLevel(RiskLevel.MEDIUM)
                            .lastUpdated(LocalDateTime.now())
                            .build();

                    return scoreRepositoryPort.save(newScore);
                });
    }

}
