package edu.ale.fintech.msclient.application.port.in;

import java.util.Optional;

import edu.ale.fintech.msclient.domain.model.Client;

public interface GetClientUseCase {
    Optional<Client> getClientWithScore(String dni);

}
