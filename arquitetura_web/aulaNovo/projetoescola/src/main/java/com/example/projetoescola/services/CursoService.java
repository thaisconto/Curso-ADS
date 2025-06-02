package com.example.projetoescola.services;

import java.util.List;

import com.example.projetoescola.dto.CursoDTO;
import com.example.projetoescola.dto.CursoRequestDTO;
import com.example.projetoescola.dto.DadosCursoDTO;

public interface CursoService {
    CursoDTO salvar(CursoRequestDTO cursoDTO);

    List<CursoDTO> obterTodos();

    DadosCursoDTO obterPorId(Long id);

    void remover(Long id);

    void editar(Long id, CursoRequestDTO dto);

}
