package com.example.ativ4.repositories;
import com.example.ativ4.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query("SELECT c FROM Curso c JOIN c.professores p WHERE p.id = :professorId")
    List<Curso> findByProfessores_Id(@Param("professorId") Long professorId);
}
