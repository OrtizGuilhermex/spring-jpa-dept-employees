package com.ctw.spring_jpa_dept_employees.dtos.departamento;

public record DepartamentoResponseDto(
        String nome,
        Long funcionario_id
) {
}
