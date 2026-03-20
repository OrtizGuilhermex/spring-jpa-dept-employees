package com.ctw.spring_jpa_dept_employees.dtos.departamento;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public record DepartamentoRequestDto(
        @Id
        @NotNull
        Long id,
        @NotNull
        String nome,
        @NotNull
        Long funcionario_id
) {
}
