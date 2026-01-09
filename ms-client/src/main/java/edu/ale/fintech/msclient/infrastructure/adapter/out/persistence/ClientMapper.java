package edu.ale.fintech.msclient.infrastructure.adapter.out.persistence;

import org.springframework.stereotype.Component;

import edu.ale.fintech.msclient.domain.model.Client;

@Component
public class ClientMapper {

    public Client toDomain(ClientEntity entity) {
        if (entity == null)
            return null;
        return Client.builder()
                .id(entity.getId())
                .dni(entity.getDni())
                .fullName(entity.getFullName())
                .income(entity.getIncome())
                .build();
    }

    public ClientEntity toEntity(Client domain) {
        if (domain == null)
            return null;
        ClientEntity entity = new ClientEntity();
        entity.setDni(domain.getDni());
        entity.setFullName(domain.getFullName());
        entity.setIncome(domain.getIncome());
        return entity;
    }
}