package com.example.ac2.models;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projetos")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @Column(length = 200, nullable = false)
    private String descricao;
   
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFim;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "projeto_funcionario",
        joinColumns = @JoinColumn(name = "projeto_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "funcionario_id", referencedColumnName = "id"),
        foreignKey = @ForeignKey(name = "fk_projeto_funcionario_projeto"),
        inverseForeignKey = @ForeignKey(name = "fk_projeto_funcionario_funcionario")
    )
    private List<Funcionario> funcionarios;

    // Métodos utilitários
    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
        funcionario.getProjetos().add(this);
    }

    public void removerFuncionario(Funcionario funcionario) {
        this.funcionarios.remove(funcionario);
        funcionario.getProjetos().remove(this);
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                '}';
    }
}