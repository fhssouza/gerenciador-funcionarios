package com.souzatech.gerenciadorFuncionarios.controller;

import com.souzatech.gerenciadorFuncionarios.model.Funcionario;
import com.souzatech.gerenciadorFuncionarios.model.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    //Acessar o formulário
    @GetMapping("/form")
    public String funcionariosForm(Funcionario funcionario) {
        return "addFuncionariosForm";
    }

    //Adicionar novo funcionário
    @PostMapping("/add")
    public String novo(@Valid Funcionario funcionario, BindingResult result){

        if (result.hasFieldErrors()){
            return "redirect:/form";
        }

        funcionarioRepository.save(funcionario);

        return "redirect:/home";
    }

    //Acessar o formulário de edição
    @GetMapping("form/{id}")
    public String updateForm(Model model, @PathVariable(name = "id") int id){

        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id: " + id));

        model.addAttribute("funcionario", funcionario);
        return "atualizaForm";

    }

    //Atualizar funcionario
    @PostMapping("update/{id}")
    public String alterarProduto(@Valid Funcionario funcionario, BindingResult result, @PathVariable int id){

        if (result.hasErrors()){
            return "redirect:/form";
        }

        funcionarioRepository.save(funcionario);
        return "redirect:/home";
    }

    //Excluir funcionário
    @GetMapping("delete/{id}")
        public String delete(@PathVariable(name = "id") int id, Model model) {

        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id" + id));

        funcionarioRepository.delete(funcionario);

        return "redirect:/home";
    }

}
