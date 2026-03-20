package com.ctw.spring_jpa_dept_employees.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    @OneToMany
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Departamento(String nome, Funcionario funcionario) {
        this.nome = nome;
        this.funcionario = funcionario;
    }
}
