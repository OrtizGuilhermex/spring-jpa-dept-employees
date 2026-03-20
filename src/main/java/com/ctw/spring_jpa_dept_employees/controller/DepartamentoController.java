package com.ctw.spring_jpa_dept_employees.controller;

import com.ctw.spring_jpa_dept_employees.dtos.departamento.DepartamentoRequestDto;
import com.ctw.spring_jpa_dept_employees.dtos.departamento.DepartamentoResponseDto;
import com.ctw.spring_jpa_dept_employees.model.Departamento;
import com.ctw.spring_jpa_dept_employees.model.Funcionario;
import com.ctw.spring_jpa_dept_employees.service.DepartamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    @PostMapping
    public DepartamentoResponseDto criarDepartamento(
            @Valid @RequestBody DepartamentoRequestDto departamentoRequestDto,
            @RequestParam Long funcionarioId
    ){
        return departamentoService.criarDepartamento(departamentoRequestDto,funcionarioId);
    }

    @GetMapping
    public List<DepartamentoResponseDto> buscarDepartamentos(){
        return departamentoService.buscarDepartamentos();
    }

    @GetMapping("/{id}")
    public DepartamentoResponseDto buscarDepartamentoPorID(
            @PathVariable Long id
    ){
        return departamentoService.buscarDepartamentoPorID(id);
    }

}
