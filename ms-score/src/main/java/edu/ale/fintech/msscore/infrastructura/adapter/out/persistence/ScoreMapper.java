package edu.ale.fintech.msscore.infrastructura.adapter.out.persistence;

import org.springframework.stereotype.Component;

import edu.ale.fintech.msscore.domain.model.RiskLevel;
import edu.ale.fintech.msscore.domain.model.Score;
import edu.ale.fintech.msscore.infrastructura.adapter.out.ScoreEntity;

@Component
public class ScoreMapper {

    public Score toDomain(ScoreEntity entity) {
        if (entity == null) {
            return null;
        }

        return Score.builder()
                .id(entity.getId())
                .customerId(entity.getCustomerId())
                .creditScore(entity.getCreditScore())
                .riskLevel(RiskLevel.valueOf(entity.getRiskLevel()))
                .lastUpdated(entity.getLastUpdate())
                .build();

    }

    public ScoreEntity toEntity(Score score) {
        if (score == null) {
            return null;
        }

        ScoreEntity entity = new ScoreEntity();
        entity.setId(score.getId());
        entity.setCustomerId(score.getCustomerId());
        entity.setCreditScore(score.getCreditScore());
        entity.setRiskLevel(score.getRiskLevel().name());
        entity.setLastUpdate(score.getLastUpdated());
        return entity;
    }   
}
