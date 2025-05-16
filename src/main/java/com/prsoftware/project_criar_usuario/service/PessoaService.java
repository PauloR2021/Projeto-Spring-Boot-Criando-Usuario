package com.prsoftware.project_criar_usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prsoftware.project_criar_usuario.entity.Pessoa;
import com.prsoftware.project_criar_usuario.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    //Criando a Classe Para mostrar Todas as Pessoas
    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }


    //Criando Classe para Salvar as Pessoas
    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    // Buscar pessoa pelo id
    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).orElse(null); // retorna null se não encontrar
    }

    // Excluir pessoa pelo id
    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }

  
}
