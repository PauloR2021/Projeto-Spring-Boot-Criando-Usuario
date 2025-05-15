package com.prsoftware.project_criar_usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prsoftware.project_criar_usuario.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
