package com.ctw.spring_jpa_dept_employees.controller;

import com.ctw.spring_jpa_dept_employees.dtos.funcionario.FuncionarioRequestDto;
import com.ctw.spring_jpa_dept_employees.dtos.funcionario.FuncionarioResponseDto;
import com.ctw.spring_jpa_dept_employees.model.Funcionario;
import com.ctw.spring_jpa_dept_employees.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> criarFuncionario(
            @RequestBody FuncionarioRequestDto funcionarioRequestDto
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(funcionarioService.cadastrarFuncionario(funcionarioRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDto>> buscarFuncionarios(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.listarFuncionarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> buscarFuncionarioPorID(
            @PathVariable Long id
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.buscarFuncionarioPorID(id));
    }

    @GetMapping("/departamento/{departamentoId}")
    public ResponseEntity<List<FuncionarioResponseDto>> buscarFuncionariosPorDepartamentoID(
            @PathVariable Long departamentoId
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.buscarFuncionariosPorDepartamentoID(departamentoId));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDto>> buscarFuncionariosPeloNome(
            @RequestParam String nome
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.buscarFuncionarioPeloNome(nome));
    }

    @GetMapping
    public ResponseEntity<FuncionarioResponseDto> buscarPeloIdENome(
            @RequestParam Long id,
            @RequestParam String nome
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.buscarFuncionarioPorIdENome(id,nome));
    }
}
