package br.com.diogomakotto.emprestimoapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="emprestimos")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String valorEmprestimoDesejado;
    @NotBlank
    private String rendaMensal;

    public Emprestimo(){

    }
    public Emprestimo(String nome, String valorEmprestimoDesejado, String rendaMensal) {
        this.nome = nome;
        this.valorEmprestimoDesejado = valorEmprestimoDesejado;
        this.rendaMensal = rendaMensal;
    }

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
