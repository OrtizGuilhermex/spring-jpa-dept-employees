package com.ctw.spring_jpa_dept_employees.controller;

import com.ctw.spring_jpa_dept_employees.dtos.departamento.DepartamentoRequestDto;
import com.ctw.spring_jpa_dept_employees.dtos.departamento.DepartamentoResponseDto;
import com.ctw.spring_jpa_dept_employees.model.Departamento;
import com.ctw.spring_jpa_dept_employees.model.Funcionario;
import com.ctw.spring_jpa_dept_employees.service.DepartamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<DepartamentoResponseDto> criarDepartamento(
            @Valid @RequestBody DepartamentoRequestDto departamentoRequestDto,
            @RequestParam Long funcionarioId
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(departamentoService.criarDepartamento(departamentoRequestDto,funcionarioId));
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDto>> buscarDepartamentos(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(departamentoService.buscarDepartamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> buscarDepartamentoPorID(
            @PathVariable Long id
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(departamentoService.buscarDepartamentoPorID(id));
    }

}
