package com.example.projetoescola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoRequestDTO {
    private String nome;
    private Integer cargaHoraria;
    private Integer categoriaCursoId;
}
