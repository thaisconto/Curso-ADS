package com.example.projetoescola.services;

import java.util.List;

import com.example.projetoescola.dto.CursoDTO;
import com.example.projetoescola.dto.CursoRequestDTO;
import com.example.projetoescola.dto.DadosCursoDTO;

public interface CursoService {
    CursoDTO salvar(CursoRequestDTO cursoDTO);
    List<CursoDTO> obterTodos();
    void editar(Long id, CursoDTO dto);
    DadosCursoDTO obterPorId(Long id);
    void excluir(Long id);
    List<DadosCursoDTO> listarTodos();

    
}
