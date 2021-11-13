package ex22;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;

public class CursoControl {

    LongProperty id = new SimpleLongProperty(0);
    StringProperty nome = new SimpleStringProperty("");
    StringProperty descricao = new SimpleStringProperty("");
    BooleanProperty ativo = new SimpleBooleanProperty(true);
    ObjectProperty inicio = new SimpleObjectProperty(LocalDate.now());
    ObjectProperty termino = new SimpleObjectProperty(LocalDate.now());
// atencao data

    private static long counter = 0;

    private CursoDAO cursoDAO = new CursoDAOImpl();
    private ObservableList<Curso> listaView = FXCollections.observableArrayList();

    public Curso getEntity() {
        Curso curso = new Curso();
        curso.setId(id.get());
        curso.setNome(nome.get());
        curso.setDescricao(descricao.get());
        curso.setAtivo(ativo.get());
        curso.setInicio((LocalDate)inicio.get());
        curso.setTermino((LocalDate)termino.get());
        return curso;
    }

    public void setEntity(Curso curso) {
        id.set(curso.getId());
        nome.set(curso.getNome());
        descricao.set(curso.getDescricao());
        ativo.set(curso.isAtivo());
        inicio.set(curso.getInicio());
        termino.set(curso.getTermino());
    }

    public void adicionar() {
        Curso curso = getEntity();
        if (curso.getId() == 0) {
            cursoDAO.adicionar(curso);
//            setEntity(new Curso());
        } else {
            cursoDAO.atualizar(id.get(), curso);
        }
        atualizarListaView();
    }

    public void novoCurso() {
        Curso curso = new Curso();
        curso.setId(0L);
        setEntity(curso);
    }

    public void pesquisarPorNome() {
        listaView.clear();
        List<Curso> encontrados = cursoDAO.pesquisarPorNome(nome.get());
        listaView.addAll(encontrados);
    }

    public void remover(long id) {
        cursoDAO.remover(id);
        atualizarListaView();
    }

    public void atualizarListaView() {
        listaView.clear();
        listaView.addAll(cursoDAO.pesquisarPorNome(""));
    }

    public ObservableList<Curso> getListaView() {
        return listaView;
    }

}
