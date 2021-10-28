package ex16;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Boundary extends Application {

    Control control = new Control();

    public void start(Stage stage) {
        Pane pan = new Pane();
        Scene scn = new Scene(pan, 600, 300);

        Label lblId = new Label("Id:");
        lblId.relocate(20, 30);
        Label lblRa = new Label("Ra:");
        lblRa.relocate(20, 60);
        Label lblNome = new Label("Nome");
        lblNome.relocate(20, 90);
        Label lblNascimento = new Label("Nascimento:");
        lblNascimento.relocate(20, 120);

        TextField txtId = new TextField();
        txtId.relocate(150,30);
        txtId.setPrefWidth(350);
        TextField txtRa = new TextField();
        txtRa.relocate(150,60);
        txtRa.setPrefWidth(350);
        TextField txtNome = new TextField();
        txtNome.relocate(150,90);
        txtNome.setPrefWidth(350);
        TextField txtNascimento = new TextField();
        txtNascimento.relocate(150,120);
        txtNascimento.setPrefWidth(350);

        Button btnSalvar = new Button("Salvar");
        btnSalvar.relocate(20, 180);
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.relocate(90, 180);

        EventHandler<ActionEvent> eventSalvar = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Aluno aluno = new Aluno();
                aluno.setId(Integer.parseInt(txtId.getText()));
                aluno.setRa(Integer.parseInt(txtRa.getText()));
                aluno.setNome(txtNome.getText());
                aluno.setNascimento(txtNascimento.getText());
                control.criaAluno(aluno);
            }
        };

        btnSalvar.setOnAction(eventSalvar);

        EventHandler<ActionEvent> eventPesquisar = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Aluno aluno = control.pesquisaAluno(Integer.parseInt(txtId.getText()));
                txtRa.setText(aluno.getRa().toString());
                txtNome.setText(aluno.getNome());
                txtNascimento.setText(aluno.getNascimento());
            }
        };

        btnPesquisar.setOnAction(eventPesquisar);

        pan.getChildren().addAll(lblId, txtId, lblRa, txtRa, lblNome,txtNome, lblNascimento, txtNascimento, btnSalvar, btnPesquisar);

        stage.setScene(scn);
        stage.setTitle("Gestão de Alunos");
        stage.show();
    }

}
