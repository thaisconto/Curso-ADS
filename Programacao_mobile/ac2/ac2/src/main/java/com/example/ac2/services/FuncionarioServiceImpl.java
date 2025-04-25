package com.example.ac2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ac2.DTO.DadosProjetoDTO;
import com.example.ac2.DTO.FuncionarioDTO;
import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Setor;
import com.example.ac2.repositories.FuncionarioRepository;
import com.example.ac2.repositories.SetorRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final SetorRepository setorRepository;

    @Override
    @Transactional
    public void adicionar(FuncionarioDTO funcionarioDTO) {
        Setor setor = setorRepository.findById(funcionarioDTO.getSetorId())
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));

        Funcionario funcionario = Funcionario.builder()
                .nome(funcionarioDTO.getNome())
                .setor(setor)
                .build();

        funcionarioRepository.save(funcionario);
    }

    @Override
    public List<DadosProjetoDTO> buscarProjetos(Integer idFuncionario) {
        Funcionario funcionario = funcionarioRepository.projetoEFuncionarioPorIdFuncionario(idFuncionario)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        return funcionario.getProjetos().stream()
                .map(p -> DadosProjetoDTO.builder()
                        .id(p.getId())
                        .descricao(p.getDescricao())
                        .dataInicio(p.getDataInicio())
                        .dataFim(p.getDataFim())
                        .build())
                .toList();
    }
}
