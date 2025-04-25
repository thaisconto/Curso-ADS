package com.example.ac2.services;

import java.time.LocalDate;
import java.util.List;

import com.example.ac2.DTO.DadosProjetoDTO;
import com.example.ac2.DTO.ProjetoDTO;

public interface ProjetoService {
    void adicionar(ProjetoDTO projetoDTO);
    
    DadosProjetoDTO buscarProjetoPorId(Integer id);
    
    void vincularFuncionario(Integer idProjeto, Integer idFuncionario);
    
    List<DadosProjetoDTO> buscarProjetosEntreDatas(LocalDate inicio, LocalDate fim);
}
