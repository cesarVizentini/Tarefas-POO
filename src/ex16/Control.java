package ex16;

import java.util.ArrayList;

public class Control {

    ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();

    public void criaAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public Aluno pesquisaAluno(Integer id) {

        if (listaAlunos.size() > id) {
            return listaAlunos.get(id) ;
        }

        System.out.println("aluno procurado nao existe");
        return null;
    }

}
