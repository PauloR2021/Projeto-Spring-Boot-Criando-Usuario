package com.prsoftware.project_criar_usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.prsoftware.project_criar_usuario.entity.Pessoa;
import com.prsoftware.project_criar_usuario.service.PessoaService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    //O metodo Mostrar Formualario com o Anotação @GetMapping precisa estar na Frente para Funcionar o Campos de Formulario
    @GetMapping("/pessoas")
    public String formulario(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "pessoas"; // formulário de cadastro
    }
    //Criando a API para Salvar Pessoas sem ter interface gráfica
    @PostMapping("/pessoas")
    public String salvarPessoa(@ModelAttribute Pessoa pessoa){
        pessoaService.save(pessoa);
        return "redirect:/pessoas";
    }
   
    //Criando a API para listar as Pessoas Criadas
    @GetMapping("/consultar")
    public String listarPessoas(Model model) {
        model.addAttribute("pessoas", pessoaService.findAll());
        return "consultar";
    }

    // Mostrar formulário para editar pessoa
    @GetMapping("/editar/{id}")
    public String editarPessoa(@PathVariable Long id, Model model) {
        Pessoa pessoa = pessoaService.findById(id);
        if (pessoa == null) {
            return "redirect:/consultar"; // se pessoa não existir, redireciona
        }
        model.addAttribute("pessoa", pessoa);
        return "alterar"; // página para editar pessoa (formulário)
    }

    // Receber o POST do formulário de edição para atualizar pessoa
    @PostMapping("/editar")
    public String atualizarPessoa(@ModelAttribute Pessoa pessoa) {
        pessoaService.save(pessoa); // save atualiza se já existir id
        return "redirect:/consultar";
    }

    // Excluir pessoa pelo id
    @GetMapping("/excluir/{id}")
    public String excluirPessoa(@PathVariable Long id) {
        pessoaService.deleteById(id);
        return "redirect:/consultar";
    }
    
    

}
