package ex13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Calculadora extends Application {

    @Override
    public void start(Stage stage) {
        Pane pan = new Pane();
        Scene scn = new Scene(pan, 180, 300);


        TextField txtId = new TextField();
        txtId.relocate(20,30);
        txtId.setPrefWidth(100);

        Button btnCE = new Button("CE");
        btnCE.relocate(140, 30);

        Button btnUm = new Button("1");
        btnUm.relocate(20, 80);
        Button btnDois = new Button("2");
        btnDois.relocate(60, 80);
        Button btnTres = new Button("3");
        btnTres.relocate(100, 80);
        Button btnMais = new Button("+");
        btnMais.relocate(140, 80);

        Button btnQuatro = new Button("4");
        btnQuatro.relocate(20, 130);
        Button btnCinco = new Button("5");
        btnCinco.relocate(60, 130);
        Button btnSeis = new Button("6");
        btnSeis.relocate(100, 130);
        Button btnMenos = new Button("-");
        btnMenos.relocate(140, 130);

        Button btnSete = new Button("7");
        btnSete.relocate(20, 180);
        Button btnOito = new Button("8");
        btnOito.relocate(60, 180);
        Button btnNove = new Button("9");
        btnNove.relocate(100, 180);
        Button btnVezes = new Button("*");
        btnVezes.relocate(140, 180);

        Button btnVirgula = new Button(",");
        btnVirgula.relocate(20, 230);
        Button btnZero = new Button("0");
        btnZero.relocate(60, 230);
        Button btnIgual = new Button("=");
        btnIgual.relocate(100, 230);
        Button btnBarra = new Button("/");
        btnBarra.relocate(140, 230);

        pan.getChildren().addAll(txtId, btnCE, btnUm, btnDois, btnTres, btnMais, btnQuatro, btnCinco, btnSeis, btnMenos,
                btnSete, btnOito, btnNove, btnVezes, btnVirgula, btnZero, btnIgual, btnBarra);

        stage.setScene(scn);
        stage.setTitle("Calculdora");
        stage.show();
    }
}
