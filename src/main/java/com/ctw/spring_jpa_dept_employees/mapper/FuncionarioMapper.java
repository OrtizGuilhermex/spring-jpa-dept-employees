package com.ctw.spring_jpa_dept_employees.mapper;

import com.ctw.spring_jpa_dept_employees.dtos.funcionario.FuncionarioRequestDto;
import com.ctw.spring_jpa_dept_employees.dtos.funcionario.FuncionarioResponseDto;
import com.ctw.spring_jpa_dept_employees.model.Funcionario;

public class FuncionarioMapper {

    public Funcionario toEntity(
            FuncionarioRequestDto funcionarioRequestDto
    ){
        return new Funcionario(
                funcionarioRequestDto.nome(),
                funcionarioRequestDto.email()
        );
    }

    public FuncionarioResponseDto toResponse(
            Funcionario funcionario
    ){
        return new FuncionarioResponseDto(
                funcionario.getNome(),
                funcionario.getEmail()
        );
    }
}
