package edu.ale.fintech.msclient.infrastructure.adapter.in.rest;

import edu.ale.fintech.msclient.application.port.in.GetClientUseCase;
import edu.ale.fintech.msclient.domain.model.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    private final GetClientUseCase getClientUseCase;

    @GetMapping("/{dni}")
    public ResponseEntity<Client> getClient(@PathVariable String dni) {
        log.info("Recibida petición REST para buscar cliente con DNI: {}", dni);
        
        return getClientUseCase.getClientWithScore(dni)
                .map(client -> {
                    log.info("Respuesta exitosa para DNI: {}", dni);
                    return ResponseEntity.ok(client);
                })
                .orElseGet(() -> {
                    log.warn("Cliente no encontrado con DNI: {}", dni);
                    return ResponseEntity.notFound().build();
                });
    }
}