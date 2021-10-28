package ex17;

public class Curso {

    private Integer id;
    private String nome;
    private Integer codCurso;
    private String nomeCoordenador;
    private Integer quantAlunos;

    public Curso() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public String getNomeCoordenador() {
        return nomeCoordenador;
    }

    public void setNomeCoordenador(String nomeCoordenador) {
        this.nomeCoordenador = nomeCoordenador;
    }

    public Integer getQuantAlunos() {
        return quantAlunos;
    }

    public void setQuantAlunos(Integer quantAlunos) {
        this.quantAlunos = quantAlunos;
    }
}
