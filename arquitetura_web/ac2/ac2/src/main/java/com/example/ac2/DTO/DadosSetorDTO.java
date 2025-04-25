package com.example.ac2.DTO;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DadosSetorDTO {
    private Integer id;
    private String nome;
    private List<FuncionarioDTO> funcionarios;
}