package com.souzatech.gerenciadorFuncionarios.model.repository;

import com.souzatech.gerenciadorFuncionarios.model.Funcionario;
import com.souzatech.gerenciadorFuncionarios.model.FuncionarioSetor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    List<Funcionario> findBySetor(FuncionarioSetor funcionarioSetor);
}
