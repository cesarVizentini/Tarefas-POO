package ex18;

public class Main {

    public static void main(String[] args) {

        SuperInteressante superInteressante = new SuperInteressante();
        Revista revista = new Revista();
        Leitor cesar = new Leitor();

        superInteressante.registrar(cesar);

        superInteressante.publicarArtigo(revista);

    }
}
