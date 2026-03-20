package com.ctw.spring_jpa_dept_employees.repository;

import com.ctw.spring_jpa_dept_employees.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Long> {
}
