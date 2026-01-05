package edu.ale.fintech.msscore.application.port.in;

import edu.ale.fintech.msscore.domain.model.Score;

public interface GetScoreUseCase {
    Score execute(String customerId);

}
