package com.example.ativ4.services;
import com.example.ativ4.config.exceptions.AgendaNaoDisponivelException;
import com.example.ativ4.config.exceptions.EspecialidadeIncompativelException;
import com.example.ativ4.models.Agenda;
import com.example.ativ4.models.Curso;
import com.example.ativ4.models.Professor;
import com.example.ativ4.repositories.AgendaRepository;
import com.example.ativ4.repositories.CursoRepository;
import com.example.ativ4.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public Agenda cadastrarAgenda(Long professorId, Long cursoId, LocalDateTime inicio, LocalDateTime fim) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        if (!professor.getEspecialidade().equalsIgnoreCase(curso.getNome())) {
            throw new EspecialidadeIncompativelException("Professor não possui a especialidade para este curso.");
        }

        List<Agenda> agendasConflitantes = agendaRepository.findOverlappingAgendas(professorId, inicio, fim);
        if (!agendasConflitantes.isEmpty()) {
            throw new AgendaNaoDisponivelException("A agenda para este professor já está preenchida neste horário.");
        }

        Agenda agenda = new Agenda();
        agenda.setProfessor(professor);
        agenda.setCurso(curso);
        agenda.setDataHoraInicio(inicio);
        agenda.setDataHoraFim(fim);
        return agendaRepository.save(agenda);
    }

    public List<Agenda> getProfessorAgenda(Long professorId) {
        return agendaRepository.findByProfessor_Id(professorId);
    }

    public Optional<Agenda> findById(Long id) {
        return agendaRepository.findById(id);
    }

    public Agenda save(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public void deleteById(Long id) {
        agendaRepository.deleteById(id);
    }

    public Agenda cadastrarObservacao(Long agendaId, String observacao) {
        Optional<Agenda> agendaOptional = agendaRepository.findById(agendaId);
        if (agendaOptional.isPresent()) {
            Agenda agenda = agendaOptional.get();
            agenda.setObservacao(observacao);
            return agendaRepository.save(agenda);
        }
        throw new RuntimeException("Agenda não encontrada");
    }

    public List<Agenda> getProfessorAgendaAndCursos(Long professorId) {
        return agendaRepository.findByProfessor_Id(professorId);
    }
}
