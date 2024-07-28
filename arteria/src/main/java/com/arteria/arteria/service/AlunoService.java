package com.arteria.service;

import com.arteria.model.Aluno;

public interface AlunoService {
    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Aluno aluno);

    void atualizar(Long id, Aluno aluno);

    void deletar(Long id);
}
