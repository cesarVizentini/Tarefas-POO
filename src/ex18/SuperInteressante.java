package ex18;

import java.util.ArrayList;
import java.util.List;

public class SuperInteressante implements Subject {

    private List<Leitor> leitores = new ArrayList<>();

    @Override
    public void publicarArtigo(Revista revista) {
        System.out.println("Super Interessante publica " + revista.artigo());
        for(Leitor leitor : leitores) {
            leitor.update(revista);
        }
    }

    @Override
    public void registrar(Observer observer) {
        leitores.add((Leitor) observer);
    }
}
