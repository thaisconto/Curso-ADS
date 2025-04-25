package com.example.ac2.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ac2.DTO.DadosSetorDTO;
import com.example.ac2.DTO.FuncionarioDTO;
import com.example.ac2.DTO.SetorDTO;
import com.example.ac2.models.Setor;
import com.example.ac2.repositories.SetorRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SetorServiceImpl implements SetorService {

    private final SetorRepository setorRepository;

    @Override
    @Transactional
    public SetorDTO criar(SetorDTO setorDTO) {
        Setor setor = new Setor();
        setor.setNome(setorDTO.getNome());
        
        Setor setorSalvo = setorRepository.save(setor);
        
        return SetorDTO.builder()
                .id(setorSalvo.getId())
                .nome(setorSalvo.getNome())
                .build();
    }

    @Override
    public List<SetorDTO> listarTodos() {
        return setorRepository.findAll().stream()
                .map(setor -> SetorDTO.builder()
                        .id(setor.getId())
                        .nome(setor.getNome())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
public DadosSetorDTO buscarPorId(Integer id) {
    Setor setor = setorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
    
    List<FuncionarioDTO> funcionariosDTO = Optional.ofNullable(setor.getFuncionarios())
            .orElse(Collections.emptyList())
            .stream()
            .map(funcionario -> FuncionarioDTO.builder()
                    .id(funcionario.getId())
                    .nome(funcionario.getNome())
                    .build())
            .collect(Collectors.toList());
        
        return DadosSetorDTO.builder()
                .id(setor.getId())
                .nome(setor.getNome())
                .funcionarios(funcionariosDTO)
                .build();
    }

    @Override
    @Transactional
    public void excluir(Integer id) {
        Setor setor = setorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
        setorRepository.delete(setor);
    }

    @Override
    @Transactional
    public SetorDTO atualizar(Integer id, SetorDTO setorDTO) {
        Setor setor = setorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
        
        setor.setNome(setorDTO.getNome());
        Setor setorAtualizado = setorRepository.save(setor);
        
        return SetorDTO.builder()
                .id(setorAtualizado.getId())
                .nome(setorAtualizado.getNome())
                .build();
    }
}
