package edu.ale.fintech.msscore.infrastructure.adapter.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import edu.ale.fintech.msscore.application.port.out.ScoreRepositoryPort;
import edu.ale.fintech.msscore.domain.model.Score;
import edu.ale.fintech.msscore.infrastructure.adapter.out.ScoreEntity;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ScorePersistenceAdapter implements ScoreRepositoryPort {

    private final JpaScoreRepository jpaScoreRepository;
    private final ScoreMapper scoreMapper;

    @Override
    public Optional<Score> findByCustomerId(String customerId) {
        return jpaScoreRepository.findByCustomerId(customerId)
                .map(scoreMapper::toDomain);
    }

    @Override
    public Score save(Score score) {
        ScoreEntity entity = scoreMapper.toEntity(score);
        ScoreEntity savedEntity = jpaScoreRepository.save(entity);

        return scoreMapper.toDomain(savedEntity);
    }

}
