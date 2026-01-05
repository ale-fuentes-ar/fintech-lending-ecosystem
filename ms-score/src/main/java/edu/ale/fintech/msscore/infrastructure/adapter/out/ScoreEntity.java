package edu.ale.fintech.msscore.infrastructure.adapter.out;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

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
    private String riskLevel;
    private LocalDateTime lastUpdate;
}
