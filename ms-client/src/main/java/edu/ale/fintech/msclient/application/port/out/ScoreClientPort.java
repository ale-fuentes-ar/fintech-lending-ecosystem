package edu.ale.fintech.msclient.application.port.out;

import java.util.Optional;

import edu.ale.fintech.msclient.infrastructure.adapter.out.external.dto.ScoreExternalResponse;

public interface ScoreClientPort {
    Optional<ScoreExternalResponse> fetchScore(String dni);
}
