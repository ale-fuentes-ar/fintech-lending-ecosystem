package edu.ale.fintech.msclient.domain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private Long id;
    private String dni;
    private String fullName;
    private BigDecimal income;

    // Estos campos se llenarán con la respuesta del Microservicio B
    private Integer creditScore;
    private String riskLevel;

}
