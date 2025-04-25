package com.example.ac2.services;

import java.util.List;

import com.example.ac2.DTO.DadosSetorDTO;
import com.example.ac2.DTO.SetorDTO;

public interface SetorService {
    SetorDTO criar(SetorDTO setorDTO);
    List<SetorDTO> listarTodos();
    DadosSetorDTO buscarPorId(Integer id);
    void excluir(Integer id);
    SetorDTO atualizar(Integer id, SetorDTO setorDTO);
}