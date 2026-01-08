package edu.ale.fintech.msclient.domain.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.ale.fintech.msclient.application.port.in.GetClientUseCase;
import edu.ale.fintech.msclient.application.port.out.ClientRepositoryPort;
import edu.ale.fintech.msclient.application.port.out.ScoreClientPort;
import edu.ale.fintech.msclient.domain.model.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService implements GetClientUseCase {

    private final ClientRepositoryPort clientRepositoryPort;
    private final ScoreClientPort scoreClientPort;

    @Override
    public Optional<Client> getClientWithScore(String dni) {
        log.info("Iniciando búsqueda de cliente con DNI: {}", dni);

        return clientRepositoryPort.findByDni(dni).map(client -> {
            log.info("Cliente encontrado en DB: {}. Solicitando score externo...", client.getFullName());

            scoreClientPort.fetchScore(dni).ifPresent(scoreResponse -> {
                log.info("Score recibido con éxito: {} - {}", scoreResponse.getCreditScore(),
                        scoreResponse.getRiskLevel());
                client.setCreditScore(scoreResponse.getCreditScore());
                client.setRiskLevel(scoreResponse.getRiskLevel());
            });

            return client;
        });
    }
}