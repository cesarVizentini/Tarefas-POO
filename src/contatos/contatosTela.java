package contatos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class contatosTela extends Application {

    @Override
    public void start(Stage stage) {
        Pane pan = new Pane();
        Scene scn = new Scene(pan, 600, 300);

        Label lblId = new Label("Id:");
        lblId.relocate(20, 30);
        Label lblNome = new Label("Nome");
        lblNome.relocate(20, 80);
        Label lblTelefone = new Label("Telefone:");
        lblTelefone.relocate(20, 130);

        TextField txtId = new TextField();
        txtId.relocate(150,30);
        txtId.setPrefWidth(350);
        TextField txtNome = new TextField();
        txtNome.relocate(150,80);
        txtNome.setPrefWidth(350);
        TextField txtTelefone = new TextField();
        txtTelefone.relocate(150,130);
        txtTelefone.setPrefWidth(350);

        Button btnSalvar = new Button("Salvar");
        btnSalvar.relocate(20, 180);
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.relocate(90, 180);

        pan.getChildren().addAll(lblId, txtId, lblNome,txtNome, lblTelefone, txtTelefone, btnSalvar, btnPesquisar);


        stage.setScene(scn);
        stage.setTitle("Agenda de Contatos");
        stage.show();
    }
}
