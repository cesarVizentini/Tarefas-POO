package ex22;

import java.time.LocalDate;

public class Curso {

    private Long id;
    private String nome;
    private String descricao;
    private boolean ativo;
    private LocalDate  inicio;
    private LocalDate  termino;

    public Curso() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate  getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate  inicio) {
        this.inicio = inicio;
    }

    public LocalDate  getTermino() {
        return termino;
    }

    public void setTermino(LocalDate  termino) {
        this.termino = termino;
    }
}
