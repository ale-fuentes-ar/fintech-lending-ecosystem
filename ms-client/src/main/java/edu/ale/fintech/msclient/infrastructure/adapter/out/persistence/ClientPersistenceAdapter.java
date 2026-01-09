package edu.ale.fintech.msclient.infrastructure.adapter.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import edu.ale.fintech.msclient.application.port.out.ClientRepositoryPort;
import edu.ale.fintech.msclient.domain.model.Client;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientPersistenceAdapter implements ClientRepositoryPort {

    private final JpaClientRepository jpaClientRepository;
    private final ClientMapper clientMapper;

    @Override
    public Optional<Client> findByDni(String dni) {
        return jpaClientRepository.findByDni(dni)
                .map(clientMapper::toDomain);
    }

    @Override
    public Client save(Client client) {
        ClientEntity entity = clientMapper.toEntity(client);
        return clientMapper.toDomain(jpaClientRepository.save(entity));
    }

}
