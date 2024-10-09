package br.com.fiap.mvc.respository;

import br.com.fiap.mvc.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
