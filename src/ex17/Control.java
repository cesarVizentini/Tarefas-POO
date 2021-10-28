package ex17;

import java.util.ArrayList;

public class Control {

    ArrayList<Curso> listaCursos = new ArrayList<Curso>();
    public void criaCurso(Curso curso) {
        listaCursos.add(curso);
    }

    public Curso pesquisaCurso(Integer id) {

        if (listaCursos.size() > id) {
            return listaCursos.get(id) ;
        }

        System.out.println("curso procurado nao existe");
        return null;
    }

}
