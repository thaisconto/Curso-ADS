package com.example.ativ4.repositories;
import com.example.ativ4.models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    @Query("SELECT a FROM Agenda a WHERE a.professor.id = :professorId AND ((a.dataHoraInicio < :fim AND a.dataHoraFim > :inicio) OR (a.dataHoraInicio = :inicio AND a.dataHoraFim = :fim))")
    List<Agenda> findOverlappingAgendas(@Param("professorId") Long professorId, @Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);

    List<Agenda> findByProfessor_Id(Long professorId);

    @Query("SELECT a FROM Agenda a WHERE a.professor.id = :professorId AND a.curso.id = :cursoId")
    List<Agenda> findByProfessor_IdAndCurso_Id(@Param("professorId") Long professorId, @Param("cursoId") Long cursoId);
}
