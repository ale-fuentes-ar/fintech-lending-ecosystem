package edu.ale.fintech.msscore.application.port.out;

import java.util.Optional;
import edu.ale.fintech.msscore.domain.model.Score;

public interface ScoreRepositoryPort {
    Optional<Score> findByCustomerId(String customerId);

    Score save(Score score);

}
