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
@Table(name = "funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "funcionario")
    private List<Departamento> departamentos;

    public Funcionario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
