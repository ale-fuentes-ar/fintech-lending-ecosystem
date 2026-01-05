package edu.ale.fintech.msscore.infrastructure.adapter.out;

import java.time.LocalDateTime;

import edu.ale.fintech.msscore.domain.model.RiskLevel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "scores")
@Getter
@Setter
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String customerId;

    private Integer creditScore;

    @Enumerated(EnumType.STRING)
    private RiskLevel riskLevel;
    private LocalDateTime lastUpdate;
}
