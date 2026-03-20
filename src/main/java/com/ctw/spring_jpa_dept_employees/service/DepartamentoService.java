package com.ctw.spring_jpa_dept_employees.service;

import com.ctw.spring_jpa_dept_employees.dtos.departamento.DepartamentoRequestDto;
import com.ctw.spring_jpa_dept_employees.dtos.departamento.DepartamentoResponseDto;
import com.ctw.spring_jpa_dept_employees.dtos.funcionario.FuncionarioRequestDto;
import com.ctw.spring_jpa_dept_employees.dtos.funcionario.FuncionarioResponseDto;
import com.ctw.spring_jpa_dept_employees.mapper.DepartamentoMapper;
import com.ctw.spring_jpa_dept_employees.mapper.FuncionarioMapper;
import com.ctw.spring_jpa_dept_employees.model.Departamento;
import com.ctw.spring_jpa_dept_employees.model.Funcionario;
import com.ctw.spring_jpa_dept_employees.repository.DepartamentoRepository;
import com.ctw.spring_jpa_dept_employees.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private final DepartamentoMapper departamentoMapper;
    private final FuncionarioRepository funcionarioRepository;

    public DepartamentoResponseDto criarDepartamento(
            DepartamentoRequestDto departamentoRequestDto,
            Long funcionarioId
    ){

        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Departamento departamento = departamentoMapper.toEntity(departamentoRequestDto,funcionario);

        departamentoRepository.save(departamento);

        return departamentoMapper.toResponse(departamento);
    }

    public List<DepartamentoResponseDto> buscarDepartamentos(){
        List<Departamento> departamentoList = departamentoRepository.findAll();

        return departamentoList.stream()
                .map(departamentoMapper::toResponse)
                .toList();
    }

    public DepartamentoResponseDto buscarDepartamentoPorID(
            Long id
    ){
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Departamento não encontrado"));

        return departamentoMapper.toResponse(departamento);
    }



}
