package edu.ale.fintech.msscore.domain.model;

import edu.ale.fintech.msscore.domain.model.RiskLevel;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    private Long id;
    private String customerId;
    private Integer creditScore;
    private RiskLevel riskLevel;
    private LocalDateTime lastUpdated;

}
