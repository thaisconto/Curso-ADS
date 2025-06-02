package com.example.projetoescola.dto;

import com.example.projetoescola.models.CategoriaCurso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosCursoDTO {
    private Long id;
    private String nome;
    private Integer cargaHoraria;
    private CategoriaCursoDTO categoriaCurso;
}
