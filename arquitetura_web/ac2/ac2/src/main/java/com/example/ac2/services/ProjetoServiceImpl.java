package com.example.ac2.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ac2.DTO.DadosProjetoDTO;
import com.example.ac2.DTO.ProjetoDTO;
import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Projeto;
import com.example.ac2.repositories.FuncionarioRepository;
import com.example.ac2.repositories.ProjetoRepository;
import com.example.ac2.DTO.FuncionarioDTO; 

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjetoServiceImpl implements ProjetoService {
    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Override
    @Transactional
    public void adicionar(ProjetoDTO projetoDTO) {
        Projeto projeto = Projeto.builder()
                .descricao(projetoDTO.getDescricao())
                .dataInicio(projetoDTO.getDataInicio())
                .dataFim(projetoDTO.getDataFim())
                .build();

        if (projetoDTO.getFuncionariosIds() != null) {
            List<Funcionario> funcionarios = funcionarioRepository.findAllById(projetoDTO.getFuncionariosIds());
            projeto.setFuncionarios(funcionarios);
        }

        projetoRepository.save(projeto);
    }

    @Override
    public DadosProjetoDTO buscarProjetoPorId(Integer id) {
        Projeto projeto = projetoRepository.projetoEFuncionarioPorIdProjeto(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        return DadosProjetoDTO.builder()
                .id(projeto.getId())
                .descricao(projeto.getDescricao())
                .dataInicio(projeto.getDataInicio())
                .dataFim(projeto.getDataFim())
                .funcionarios(projeto.getFuncionarios().stream()
                        .map(f -> FuncionarioDTO.builder()
                                .id(f.getId())
                                .nome(f.getNome())
                                .setorId(f.getSetor() != null ? f.getSetor().getId() : null)
                                .build())
                        .toList())
                .build();
    }

    @Override
    @Transactional
    public void vincularFuncionario(Integer idProjeto, Integer idFuncionario) {
        Projeto projeto = projetoRepository.findById(idProjeto)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
    }

    @Override
    public List<DadosProjetoDTO> buscarProjetosEntreDatas(LocalDate inicio, LocalDate fim) {
        return projetoRepository.projetoEntreDatas(inicio, fim).stream()
                .map(p -> DadosProjetoDTO.builder()
                        .id(p.getId())
                        .descricao(p.getDescricao())
                        .dataInicio(p.getDataInicio())
                        .dataFim(p.getDataFim())
                        .build())
                .toList();
    }
}
