package edu.ale.fintech.msscore.infrastructura.adapter.in.rest.dto;

import java.time.LocalDateTime;

import edu.ale.fintech.msscore.domain.model.RiskLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScoreResponse {
    private String customerId;
    private Integer creditScore;
    private RiskLevel riskLevel;
    private LocalDateTime lastUpdate;
}
