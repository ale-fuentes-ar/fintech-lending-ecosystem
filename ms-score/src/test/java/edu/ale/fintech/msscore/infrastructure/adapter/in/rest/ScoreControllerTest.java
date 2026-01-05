package edu.ale.fintech.msscore.infrastructure.adapter.in.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import edu.ale.fintech.msscore.application.port.in.GetScoreUseCase;
import edu.ale.fintech.msscore.domain.model.RiskLevel;
import edu.ale.fintech.msscore.domain.model.Score;

@WebMvcTest(ScoreController.class)
public class ScoreControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GetScoreUseCase getScoreUseCase;

    @Test
    @DisplayName("GET /api/v1/scores/{customerId} should return score details")
    void shouldReturnScoreDetails() throws Exception {
        Score mockScore = Score.builder()
                .customerId("CUST-001")
                .creditScore(800)
                .riskLevel(RiskLevel.LOW)
                .lastUpdated(LocalDateTime.now())
                .build();

        when(getScoreUseCase.execute("CUST-001")).thenReturn(mockScore);

        mockMvc.perform(get("/api/v1/scores/CUST-001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId").value("CUST-001"))
                .andExpect(jsonPath("$.creditScore").value(800))
                .andExpect(jsonPath("$.riskLevel").value("LOW"));
    }

}
