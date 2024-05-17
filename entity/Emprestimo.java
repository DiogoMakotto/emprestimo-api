package br.com.diogomakotto.emprestimoapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name="emprestimos")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String valorEmprestimoDesejado;
    private String rendaMensal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValorEmprestimoDesejado() {
        return valorEmprestimoDesejado;
    }

    public void setValorEmprestimoDesejado(String valorEmprestimoDesejado) {
        this.valorEmprestimoDesejado = valorEmprestimoDesejado;
    }

    public String getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(String rendaMensal) {
        this.rendaMensal = rendaMensal;
    }
}
