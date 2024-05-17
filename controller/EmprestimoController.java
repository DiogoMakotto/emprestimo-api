package br.com.diogomakotto.emprestimoapi.controller;

import br.com.diogomakotto.emprestimoapi.entity.Emprestimo;
import br.com.diogomakotto.emprestimoapi.service.EmprestimoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    List<Emprestimo> create(@RequestBody @Valid Emprestimo emprestimo){
        return emprestimoService.create(emprestimo);
    }

    @GetMapping
    List<Emprestimo> list(){
        return emprestimoService.list();
    }

    @PutMapping
    List<Emprestimo> update(@RequestBody Emprestimo emprestimo){
        return emprestimoService.update(emprestimo);
    }

    @DeleteMapping("{id}")
    List<Emprestimo> delete(@PathVariable("id") Long id){
        return emprestimoService.delete(id);
    }
}
