package com.example.ativ4.services;
import com.example.ativ4.models.Curso;
import com.example.ativ4.models.Professor;
import com.example.ativ4.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Optional<Professor> findById(Long id) {
        return professorRepository.findById(id);
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public void deleteById(Long id) {
        professorRepository.deleteById(id);
    }

    public List<Professor> findByCurso(Long cursoId) {
        return professorRepository.findByCursos_Id(cursoId);
    }

    public List<Curso> findProfessorCursosAndSchedules(Long professorId) {
        Optional<Professor> professorOptional = professorRepository.findById(professorId);
        return professorOptional.map(Professor::getCursos).orElse(List.of());
        // You'll likely need to fetch the agenda details here as well,
        // perhaps by joining with the Agenda repository.
    }

    public Optional<Professor> findProfessorDetails(Long professorId) {
        return professorRepository.findById(professorId);
    }
}
