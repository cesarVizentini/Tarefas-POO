package ex22;

import java.util.List;

public interface CursoDAO {
    void adicionar(Curso curso);
    List<Curso> pesquisarPorNome(String nome);
    void atualizar(long id, Curso curso);
    void remover(long id);
}
