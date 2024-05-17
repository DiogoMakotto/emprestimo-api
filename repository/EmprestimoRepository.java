package br.com.diogomakotto.emprestimoapi.repository;

import br.com.diogomakotto.emprestimoapi.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmprestimoRepository extends JpaRepository <Emprestimo, Long> {

}
