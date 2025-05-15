package com.prsoftware.project_criar_usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prsoftware.project_criar_usuario.entity.Pessoa;
import com.prsoftware.project_criar_usuario.repository.PessoaRepository;

@Service
public class PessoasService {

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

}
