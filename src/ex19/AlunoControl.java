package ex19;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoControl {

    LongProperty id = new SimpleLongProperty(0);
    LongProperty ra = new SimpleLongProperty(0);
    StringProperty nome = new SimpleStringProperty("");
    ObjectProperty nascimento = new SimpleObjectProperty(LocalDate.now());

    private static long counter = 0;

    private List<Aluno> lista = new ArrayList<>();
    private ObservableList<Aluno> listaView = FXCollections.observableArrayList();

    public Aluno getEntity() {
        Aluno aluno = new Aluno();
        aluno.setId(id.get());
        aluno.setRa(ra.get());
        aluno.setNome(nome.get());
        aluno.setNascimento((LocalDate)nascimento.get());
        return aluno;
    }

    public void setEntity(Aluno aluno) {
        id.set(aluno.getId());
        nome.set(aluno.getNome());
        ra.set(aluno.getRa());
        nascimento.set(aluno.getNascimento());
    }

    public void salvar() {
        Aluno aluno = getEntity();
        boolean encontrado = false;
        for (int i = 0; i < lista.size(); i++) {
            Aluno a = lista.get(i);
            if (aluno.getId() == a.getId()) {
                lista.set(i, aluno);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            lista.add(aluno);
        }
        atualizarListaView();
        aluno.setId(++counter);
    }

    public void pesquisar() {
        listaView.clear();
        for(Aluno aluno : lista) {
            if (aluno.getNome().contains(nome.get())) {
                listaView.add(aluno);
                // setEntity(p);
                // break;
            }
        }
    }

    public void remover(long id) {
        for (Aluno aluno : lista) {
            if (aluno.getId() == id) {
                lista.remove(aluno);
                break;
            }
        }
        atualizarListaView();
    }

    public void atualizarListaView() {
        listaView.clear();
        listaView.addAll(lista);
    }

    public ObservableList<Aluno> getListaView() {
        return listaView;
    }

}
