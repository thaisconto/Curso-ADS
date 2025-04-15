package com.example.projetoescola.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoDTO {
    private long id;
    private String nome;
    private Integer categoriaCursoId;
    private Integer cargaHoraria;
}


