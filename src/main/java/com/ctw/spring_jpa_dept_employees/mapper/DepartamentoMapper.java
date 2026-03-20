package com.ctw.spring_jpa_dept_employees.mapper;

import com.ctw.spring_jpa_dept_employees.dtos.departamento.DepartamentoRequestDto;
import com.ctw.spring_jpa_dept_employees.dtos.departamento.DepartamentoResponseDto;
import com.ctw.spring_jpa_dept_employees.model.Departamento;
import com.ctw.spring_jpa_dept_employees.model.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoMapper {

    public Departamento toEntity(
            DepartamentoRequestDto departamentoRequestDto,
            Funcionario funcionario
    ){
        return new Departamento(
                departamentoRequestDto.id(),
                departamentoRequestDto.nome(),
                funcionario
        );
    }

    public DepartamentoResponseDto toResponse(
            Departamento departamento
    ){
        return new DepartamentoResponseDto(
                departamento.getNome(),
                departamento.getFuncionario().getId()
        );
    }
}
