package com.example.ativ4.repositories;
import com.example.ativ4.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    @Query("SELECT p FROM Professor p JOIN p.cursos c WHERE c.id = :cursoId")
    List<Professor> findByCursos_Id(@Param("cursoId") Long cursoId);

    @Query("SELECT p FROM Professor p JOIN p.cursos c JOIN Agenda a ON a.professor = p WHERE p.id = :professorId")
    List<Professor> findProfessorDetails(@Param("professorId") Long professorId);
}
