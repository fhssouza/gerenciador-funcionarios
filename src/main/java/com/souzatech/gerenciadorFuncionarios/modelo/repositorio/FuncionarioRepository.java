package com.souzatech.gerenciadorFuncionarios.modelo.repositorio;

import com.souzatech.gerenciadorFuncionarios.modelo.Funcionario;
import com.souzatech.gerenciadorFuncionarios.modelo.FuncionarioSetor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    List<Funcionario> findBySetor(FuncionarioSetor funcionarioSetor);
}
