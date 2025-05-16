package com.prsoftware.project_criar_usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.prsoftware.project_criar_usuario.entity.Pessoa;
import com.prsoftware.project_criar_usuario.service.PessoaService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller //Iniciando a Classe Controller
public class PessoaController {
    
    //Intanciando a Classe Service aonde está a Regra de Negocio do Projeto
    @Autowired
    private PessoaService pessoaService;

    //Criando Rota para a tela de Index do Site

    @GetMapping("/")
    public String home(){
        return "index";  
    }

    //Criando a API para listar as Pessoas Criadas
    @GetMapping("/pessoas")
    public String listarPessoas(Model model) {
        model.addAttribute("pessoas", pessoaService.findAll());
        model.addAttribute("pessoa", new Pessoa());
        return "pessoas";
    }

    //Criando a API para Salvar Pessoas sem ter interface gráfica
    @PostMapping("/pessoas")
    public String salvarPessoa(@ModelAttribute Pessoa pessoa){
        pessoaService.save(pessoa);
        return "redirect:/pessoas";
    }
    

}
