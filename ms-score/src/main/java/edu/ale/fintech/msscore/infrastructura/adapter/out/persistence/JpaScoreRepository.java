package edu.ale.fintech.msscore.infrastructura.adapter.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ale.fintech.msscore.infrastructura.adapter.out.ScoreEntity;

public interface JpaScoreRepository extends JpaRepository<ScoreEntity, Long> {
    Optional<ScoreEntity> findByCustomerId(String customerId);
}
