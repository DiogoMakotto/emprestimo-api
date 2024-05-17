package br.com.diogomakotto.emprestimoapi.service;

import br.com.diogomakotto.emprestimoapi.entity.Emprestimo;
import br.com.diogomakotto.emprestimoapi.repository.EmprestimoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {
        private EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public List<Emprestimo> create(Emprestimo emprestimo){
        emprestimoRepository.save(emprestimo);
        return list();
    }

    public List<Emprestimo> list(){
        Sort sort = Sort.by("id").descending().and(
                Sort.by("nome").ascending());
        return emprestimoRepository.findAll(sort);
    }

    public List<Emprestimo> update(Emprestimo emprestimo){
        emprestimoRepository.save(emprestimo);
        return list();
    }

    public List<Emprestimo> delete(Long id){
        emprestimoRepository.deleteById(id);
        return list();
    }

}
