package com.ctw.spring_jpa_dept_employees.dtos.funcionario;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.aspectj.weaver.ast.Not;

public record FuncionarioRequestDto(
        @Id
        @NotNull
        Long id,
        @NotNull
        String nome,
        @NotNull
        String email
) {
}
