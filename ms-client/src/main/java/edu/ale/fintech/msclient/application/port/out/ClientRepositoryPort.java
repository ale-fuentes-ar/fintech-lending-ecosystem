package edu.ale.fintech.msclient.application.port.out;

import java.util.Optional;

import edu.ale.fintech.msclient.domain.model.Client;

public interface ClientRepositoryPort {
    Optional<Client> findByDni(String dni);

    Client save(Client client);

}
