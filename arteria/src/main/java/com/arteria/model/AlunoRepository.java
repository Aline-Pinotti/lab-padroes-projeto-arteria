package com.arteria.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * interface que provê todos os métodos de acesso a dados da entidade
 * todas as operações relacionadas com o banco de dados (camada 1 - model)
 * notação Repository é opcional, pq como extendeu a classe, já fica claro
 */

@Repository
public class AlunoRepository extends CrudRepository<Aluno, Long> {

}
