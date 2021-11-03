package ex20;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class CursoControl {

    LongProperty id = new SimpleLongProperty(0);
    StringProperty nome = new SimpleStringProperty("");
    LongProperty codCurso = new SimpleLongProperty(0);
    StringProperty coordenador = new SimpleStringProperty("");
    LongProperty quantAlunos = new SimpleLongProperty(0);

    private static long counter = 0;

    private List<Curso> lista = new ArrayList<>();
    private ObservableList<Curso> listaView = FXCollections.observableArrayList();

    public Curso getEntity() {
        Curso curso = new Curso();
        curso.setId(id.get());
        curso.setNome(nome.get());
        curso.setCodCurso(codCurso.get());
        curso.setCoordenador(coordenador.get());
        curso.setQuantAlunos(quantAlunos.get());
        return curso;
    }

    public void setEntity(Curso curso) {
        id.set(curso.getId());
        nome.set(curso.getNome());
        codCurso.set(curso.getCodCurso());
        coordenador.set(curso.getCoordenador());
        quantAlunos.set(curso.getQuantAlunos());
    }

    public void salvar() {
        Curso curso = getEntity();
        boolean encontrado = false;
        for (int i = 0; i < lista.size(); i++) {
            Curso c = lista.get(i);
            if (curso.getId() == c.getId()) {
                lista.set(i, curso);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            lista.add(curso);
        }
        atualizarListaView();
        curso.setId(++counter);
    }

    public void pesquisar() {
        listaView.clear();
        for(Curso curso : lista) {
            if (curso.getNome().contains(nome.get())) {
                listaView.add(curso);
                // setEntity(p);
                // break;
            }
        }
    }

    public void remover(long id) {
        for (Curso curso : lista) {
            if (curso.getId() == id) {
                lista.remove(curso);
                break;
            }
        }
        atualizarListaView();
    }

    public void atualizarListaView() {
        listaView.clear();
        listaView.addAll(lista);
    }

    public ObservableList<Curso> getListaView() {
        return listaView;
    }

}
