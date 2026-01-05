package edu.ale.fintech.msscore.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.ale.fintech.msscore.application.port.out.ScoreRepositoryPort;
import edu.ale.fintech.msscore.domain.model.RiskLevel;
import edu.ale.fintech.msscore.domain.model.Score;

@ExtendWith(MockitoExtension.class)
public class ScoreServiceTest {

    @Mock private ScoreRepositoryPort scoreRepositoryPort;
    @InjectMocks private ScoreService scoreService;

    @Test
    @DisplayName("Should return existing score when customerID is found")
    void shouldReturnExistingScoreWhenCustomerIDIsFound() {
        // Arrange
        String customerId = "12345";
        Score mockScore = Score.builder()
                .customerId(customerId)
                .creditScore(750)
                .riskLevel(RiskLevel.LOW)
                .lastUpdated(LocalDateTime.now())
                .build();

        when(scoreRepositoryPort.findByCustomerId(customerId))
                .thenReturn(Optional.of(mockScore));

        // Act
        Score result = scoreService.execute(customerId);

        // Assert
        assertEquals(mockScore, result);
        assertEquals(RiskLevel.LOW, result.getRiskLevel());
        verify(scoreRepositoryPort, times(1)).findByCustomerId(customerId);
        
    }

}