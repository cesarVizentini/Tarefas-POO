package ex20;

public class Curso {

    private Long id;
    private String nome;
    private Long codCurso;
    private String coordenador;
    private Long quantAlunos;

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

    public Long getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Long codCurso) {
        this.codCurso = codCurso;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public Long getQuantAlunos() {
        return quantAlunos;
    }

    public void setQuantAlunos(Long quantAlunos) {
        this.quantAlunos = quantAlunos;
    }
}
