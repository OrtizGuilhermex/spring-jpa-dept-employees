package com.ctw.spring_jpa_dept_employees.controller;

import com.ctw.spring_jpa_dept_employees.dtos.funcionario.FuncionarioRequestDto;
import com.ctw.spring_jpa_dept_employees.dtos.funcionario.FuncionarioResponseDto;
import com.ctw.spring_jpa_dept_employees.model.Funcionario;
import com.ctw.spring_jpa_dept_employees.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping
    public FuncionarioResponseDto criarFuncionario(
            @RequestBody FuncionarioRequestDto funcionarioRequestDto
    ){
        return funcionarioService.cadastrarFuncionario(funcionarioRequestDto);
    }

    @GetMapping
    public List<FuncionarioResponseDto> buscarFuncionarios(){
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping("/{id}")
    public FuncionarioResponseDto buscarFuncionarioPorID(
            @PathVariable Long id
    ){
        return funcionarioService.buscarFuncionarioPorID(id);
    }

    @GetMapping("/departamento/{departamentoId}")
    public List<FuncionarioResponseDto> buscarFuncionariosPorDepartamentoID(
            @PathVariable Long departamentoId
    ){
        return funcionarioService.buscarFuncionariosPorDepartamentoID(departamentoId);
    }

    @GetMapping
    public List<FuncionarioResponseDto> buscarFuncionariosPeloNome(
            @RequestParam String nome
    ){
        return funcionarioService.buscarFuncionarioPeloNome(nome);
    }

    @GetMapping
    public FuncionarioResponseDto buscarPeloIdENome(
            @RequestParam Long id,
            @RequestParam String nome
    ){
        return funcionarioService.buscarFuncionarioPorIdENome(id,nome);
    }





}
