package com.example.projetoescola.services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<CursoDTO> obterTodos() {
    List<Curso> cursos = cursoRepository.findAll();
    List<CursoDTO> cursosDTO = cursos.stream().map(curso -> {
        // usando construtor
       // CursoDTO cursoDTO = new CursoDTO();
       // cursoDTO.setId(curso.getId());
       // cursoDTO.setNome(curso.getNome());
       // return cursoDTO;

       //usando builder
        return CursoDTO.builder()
                        .id(curso.getId())
                        .nome(curso.getNome())
                        .build();

    }).toList();

    return cursosDTO;

    
   
    /* outra forma de fazer
    List<CursoDTO> cursoDTOs = new ArrayList<>();
    for (Curso curso : cursos) {
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId(curso.getId());
        cursoDTO.setNome(curso.getNome());
        
        cursoDTOs.add(cursoDTO);
    }
    
    
    return cursoDTOs;
    */
    }



    @Override
    public CursoDTO salvar(CursoRequestDTO cursoDTO) {
        // antes de salvar o curso vai verificar se o id da categoria existe
        CategoriaCurso categ =
        categoriaCursoRepository.findById(
            cursoDTO.getCategoriaCursoId())
            .orElseThrow(()-> 
            new  RegraNegocioException("Código não encontrado."));
        
        //se encontrou o id da categoria, vai montar o objeto curso
        Curso curso = new Curso ();
        curso.setNome(cursoDTO.getNome());
        curso.setCargaHoraria(cursoDTO.getCargaHoraria());
        curso.setCategoriaCurso(categ);
        
        Curso c = cursoRepository.save(curso);

        // com o objeto pronto vai montar o retorno da requisicao
        CursoDTO cursoResponse = new CursoDTO();
        cursoResponse.setId(c.getId());
        cursoResponse.setNome(c.getNome());
        return cursoResponse;
        }

    @Override
    public void editar(Long id, CursoDTO dto) {
        Curso curso = cursoRepository.findById(id)
        .orElseThrow(() -> new RegraNegocioException("Código usuário não encontrado."));
    
        CategoriaCurso categoriaCurso =
        categoriaCursoRepository.findById(dto.getCategoriaCursoId())
        .orElseThrow(() -> new RegraNegocioException("Categoria não encontrado."));
    
        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());
        curso.setCategoriaCurso(categoriaCurso);
        cursoRepository.save(curso);
    }

    public List<DadosCursoDTO> listarTodos() {
        return cursoRepository.findAll().stream().map((Curso c) -> {
        return DadosCursoDTO.builder()
            .id(c.getId())
            .nome(c.getNome())
            .cargaHoraria(c.getCargaHoraria())
            .categoria(
            CategoriaCursoDTO.builder()
                .id(c.getCategoriaCurso().getId())
                .nome(c.getCategoriaCurso().getNome())
                .build())
            .build();
    }).collect(Collectors.toList());
    }


    @Override
    public DadosCursoDTO obterPorId(Long id) {
        return cursoRepository.findById(id).map((Curso c) -> {
        return DadosCursoDTO
            .builder()
            .id(c.getId())
            .nome(c.getNome())
            .cargaHoraria(c.getCargaHoraria())
            .categoria(CategoriaCursoDTO.builder()
                .id(c.getCategoriaCurso().getId())
                .nome(c.getCategoriaCurso().getNome()
                ).build()
            ).build();
    }).orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID fornecido"));
    }


    @Override
    @Transactional
    public void excluir(Long id) {
    cursoRepository.deleteById(id);
    }



       

    }

    
