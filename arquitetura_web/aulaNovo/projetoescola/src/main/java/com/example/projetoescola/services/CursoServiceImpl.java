package com.example.projetoescola.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoescola.config.RegraNegocioException;
import com.example.projetoescola.dto.CategoriaCursoDTO;
import com.example.projetoescola.dto.CursoDTO;
import com.example.projetoescola.dto.CursoRequestDTO;
import com.example.projetoescola.dto.DadosCursoDTO;
import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;

import jakarta.transaction.Transactional;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CategoriaCursoRepository categoriaCursoRepository;

    @Override
    public CursoDTO salvar(CursoRequestDTO cursoDTO) {
        CategoriaCurso categ = categoriaCursoRepository.findById(
                cursoDTO.getCategoriaCursoId())
                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada."));

        Curso curso = new Curso();
        curso.setNome(cursoDTO.getNome());
        curso.setCargaHoraria(cursoDTO.getCargaHoraria());
        curso.setCategoriaCurso(categ);

        Curso c = cursoRepository.save(curso);

        CursoDTO cursoResponse = new CursoDTO();
        cursoResponse.setId(c.getId());
        cursoResponse.setNome(c.getNome());
        return cursoResponse;
    }

    @Override
    public List<CursoDTO> obterTodos() {
        List<Curso> cursos = cursoRepository.findAll();
        List<CursoDTO> cursosDTO = cursos.stream().map(curso -> {
            // Usando com builder
            return CursoDTO.builder()
                    .id(curso.getId())
                    .nome(curso.getNome())
                    .build();
        }).toList();
        return cursosDTO;
    }

    @Override
    public DadosCursoDTO obterPorId(Long id) {
        return cursoRepository.findById(id).map((Curso c) -> {
            return DadosCursoDTO
                    .builder()
                    .id(c.getId())
                    .nome(c.getNome())
                    .cargaHoraria(c.getCargaHoraria())
                    .categoriaCurso(CategoriaCursoDTO.builder()
                            .id(c.getCategoriaCurso().getId())
                            .nome(c.getCategoriaCurso().getNome())
                            .build())
                    .build();
        }).orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID fornecido"));
    }

    @Override
    @Transactional
    public void remover(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public void editar(Long id, CursoRequestDTO dto) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Código curso não encontrado."));

        CategoriaCurso categoriaCurso = categoriaCursoRepository.findById(dto.getCategoriaCursoId())
                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrado."));

        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());
        curso.setCategoriaCurso(categoriaCurso);
        cursoRepository.save(curso);
    }

}
