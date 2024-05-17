package br.com.diogomakotto.emprestimoapi.service;

import br.com.diogomakotto.emprestimoapi.entity.Emprestimo;
import br.com.diogomakotto.emprestimoapi.repository.EmprestimoRepository;
import org.json.JSONException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

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

    public String calcularEmprestimo(Emprestimo emprestimo) throws JSONException {
        double rendaMensal = Double.parseDouble(emprestimo.getRendaMensal());
        double valorEmprestimo = Double.parseDouble(emprestimo.getValorEmprestimoDesejado());

        // Variáveis estáticas
        double percentualPermitido = 0.30;
        double taxaAnual = 0.12;
        int numeroParcelas = 24;

        double parcelaMaximaPermitida = rendaMensal * percentualPermitido;

        double taxaMensal = taxaAnual / 12.0;

        // Calcular o valor máximo do empréstimo (PV) usando a fórmula
        double valorMaximoEmprestimo = calcularValorMaximoEmprestimo(parcelaMaximaPermitida, taxaMensal, numeroParcelas);

        boolean aprovado = valorEmprestimo <= valorMaximoEmprestimo;

        JSONObject resposta = new JSONObject();
        resposta.put("valorMaximoEmprestimo", valorMaximoEmprestimo);
        resposta.put("aprovado", aprovado);

        return resposta.toString();
    }

    private double calcularValorMaximoEmprestimo(double pmt, double r, int n) {
        // Fórmula para calcular o valor presente (PV) do empréstimo
        return pmt * (Math.pow(1 + r, n) - 1) / (r * Math.pow(1 + r, n));
    }
}


