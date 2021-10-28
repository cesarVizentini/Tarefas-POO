package ex17;

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
        Label lblNome = new Label("Nome:");
        lblNome.relocate(20, 60);
        Label lblCodCurso = new Label("Código do Curso: ");
        lblCodCurso.relocate(20, 90);
        Label lblNomeCoordenador = new Label("Nome do Coordenador: ");
        lblNomeCoordenador.relocate(20, 120);
        Label lblQuantAlunos = new Label("Quantidade de alunos: ");
        lblQuantAlunos.relocate(20, 150);

        TextField txtId = new TextField();
        txtId.relocate(150,30);
        txtId.setPrefWidth(350);
        TextField txtNome = new TextField();
        txtNome.relocate(150,60);
        txtNome.setPrefWidth(350);
        TextField txtCodCurso = new TextField();
        txtCodCurso.relocate(150,90);
        txtCodCurso.setPrefWidth(350);
        TextField txtNomeCoordenador = new TextField();
        txtNomeCoordenador.relocate(150,120);
        txtNomeCoordenador.setPrefWidth(350);
        TextField txtQuantAlunos = new TextField();
        txtQuantAlunos.relocate(150,150);
        txtQuantAlunos.setPrefWidth(350);

        Button btnAdicionar = new Button("Adicionar");
        btnAdicionar.relocate(20, 180);
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.relocate(90, 180);

        EventHandler<ActionEvent> eventAdicionar = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Curso curso = new Curso();
                curso.setId(Integer.parseInt(txtId.getText()));
                curso.setNome(txtNome.getText());
                curso.setCodCurso(Integer.parseInt(txtCodCurso.getText()));
                curso.setNomeCoordenador(txtNomeCoordenador.getText());
                curso.setQuantAlunos(Integer.parseInt(txtQuantAlunos.getText()));
                control.criaCurso(curso);
            }
        };

        btnAdicionar.setOnAction(eventAdicionar);

        EventHandler<ActionEvent> eventPesquisar = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Curso curso = control.pesquisaCurso(Integer.parseInt(txtId.getText()));
                txtNome.setText(curso.getNome());
                txtCodCurso.setText(curso.getCodCurso().toString());
                txtNomeCoordenador.setText(curso.getNomeCoordenador());
                txtQuantAlunos.setText(curso.getQuantAlunos().toString());
            }
        };

        btnPesquisar.setOnAction(eventPesquisar);

        pan.getChildren().addAll(lblId, txtId, lblNome,txtNome, lblCodCurso, txtCodCurso, lblNomeCoordenador, txtNomeCoordenador, lblQuantAlunos, txtQuantAlunos, btnAdicionar, btnPesquisar);

        stage.setScene(scn);
        stage.setTitle("Gestão de Cursos");
        stage.show();
    }

}
