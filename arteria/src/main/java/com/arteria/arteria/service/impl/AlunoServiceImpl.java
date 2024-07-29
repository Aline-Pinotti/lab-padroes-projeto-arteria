package com.arteria.arteria.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arteria.arteria.model.*;
import com.arteria.arteria.service.*;

@Service
public class AlunoServiceImpl implements AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Aluno> buscarTodos() {
        // Buscar todos os Alunos.
        return alunoRepository.findAll();
    }

    @Override
    public Aluno buscarPorId(Long id) {
        // Buscar Aluno por ID.
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.get();
    }

    @Override
    public void inserir(Aluno aluno) {
        salvarAlunoComCep(aluno);
    }

    @Override
    public void atualizar(Long id, Aluno aluno) {
        // Buscar Aluno por ID, caso exista:
        Optional<Aluno> alunoBd = alunoRepository.findById(id);
        if (alunoBd.isPresent()) {
            salvarAlunoComCep(aluno);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Aluno por ID.
        alunoRepository.deleteById(id);
    }

    private void salvarAlunoComCep(Aluno aluno) {
        // Verificar se o Endereco do Aluno já existe (pelo CEP).
        String cep = aluno.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        aluno.setEndereco(endereco);
        // Inserir Aluno, vinculando o Endereco (novo ou existente).
        alunoRepository.save(aluno);
    }
}
