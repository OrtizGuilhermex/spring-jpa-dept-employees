package com.ctw.spring_jpa_dept_employees.service;

import com.ctw.spring_jpa_dept_employees.dtos.funcionario.FuncionarioRequestDto;
import com.ctw.spring_jpa_dept_employees.dtos.funcionario.FuncionarioResponseDto;
import com.ctw.spring_jpa_dept_employees.mapper.FuncionarioMapper;
import com.ctw.spring_jpa_dept_employees.model.Funcionario;
import com.ctw.spring_jpa_dept_employees.repository.DepartamentoRepository;
import com.ctw.spring_jpa_dept_employees.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;
    private final DepartamentoRepository departamentoRepository;

    public FuncionarioResponseDto cadastrarFuncionario(
            FuncionarioRequestDto funcionarioRequestDto
    ){
        departamentoRepository.findById(funcionarioRequestDto.id())
                .orElseThrow(()-> new RuntimeException("Departamento não encontrado"));

        Funcionario funcionario = funcionarioMapper.toEntity(funcionarioRequestDto);

        funcionarioRepository.save(funcionario);

        return funcionarioMapper.toResponse(funcionario);
    }

    public List<FuncionarioResponseDto> listarFuncionarios(){
        List<Funcionario> funcionarioList = funcionarioRepository.findAll();

        return funcionarioList.stream()
                .map(funcionarioMapper::toResponse)
                .toList();
    }

    public List<FuncionarioResponseDto> buscarFuncionariosPorDepartamentoID(
            Long departamentoId
    ){
        List<Funcionario> funcionarioList = funcionarioRepository.findByDepartamentoId(departamentoId);

        return funcionarioList.stream()
                .map(funcionarioMapper::toResponse)
                .toList();
    }

    public List<FuncionarioResponseDto> buscarFuncionarioPeloNome(
            String nome
    ){
        List<Funcionario> funcionarioList = funcionarioRepository.findByNome(nome);

        return funcionarioList.stream()
                .map(funcionarioMapper::toResponse)
                .toList();
    }

    public FuncionarioResponseDto buscarFuncionarioPorIdENome(
            Long id,
            String nome
    ){
        Funcionario funcionario = funcionarioRepository.findByIdAndNome(id,nome)
                .orElseThrow(()->new RuntimeException("Funcionario não encontrado com o ID e nome referenciados"));

        return funcionarioMapper.toResponse(funcionario);
    }


    public FuncionarioResponseDto buscarFuncionarioPorID(
            Long id
    ){
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Funcionario não encontrado"));

        return funcionarioMapper.toResponse(funcionario);
    }
}
