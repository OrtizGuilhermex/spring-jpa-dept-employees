package com.ctw.spring_jpa_dept_employees.repository;

import com.ctw.spring_jpa_dept_employees.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

    List<Funcionario> findByDepartamentoId(Long departamentoId);
    List<Funcionario> findByNome(String nome);
    Optional<Funcionario>findByIdAndNome(Long id, String nome);

}
