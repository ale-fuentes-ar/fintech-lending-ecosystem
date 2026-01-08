package edu.ale.fintech.msclient.infrastructure.adapter.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByDni(String dni);

}
