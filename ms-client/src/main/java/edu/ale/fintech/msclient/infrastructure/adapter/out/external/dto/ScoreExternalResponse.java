package edu.ale.fintech.msclient.infrastructure.adapter.out.external.dto;

import lombok.Data;

@Data
public class ScoreExternalResponse {
    private String customerId;
    private Integer creditScore;
    private String riskLevel;
}
