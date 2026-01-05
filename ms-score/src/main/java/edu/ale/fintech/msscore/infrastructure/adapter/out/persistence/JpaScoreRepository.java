package edu.ale.fintech.msscore.infrastructure.adapter.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ale.fintech.msscore.infrastructure.adapter.out.ScoreEntity;

public interface JpaScoreRepository extends JpaRepository<ScoreEntity, Long> {
    Optional<ScoreEntity> findByCustomerId(String customerId);
}
