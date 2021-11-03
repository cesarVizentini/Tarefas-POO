package ex19;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class AlunoBoundary extends Application {

    private TextField txtId = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtRa = new TextField();
    private DatePicker dtNascimento = new DatePicker();

    private Button btnSalvar = new Button("Salvar");
    private Button btnPesquisar = new Button("Pesquisar");

    private AlunoControl control = new AlunoControl();   // Composição

    private TableView<Aluno> table = new TableView<>();

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private void criarTabela() {
        TableColumn<Aluno, Long> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory( new PropertyValueFactory<>("id") );

        TableColumn<Aluno, Long> col2 = new TableColumn<>("Ra");
        col2.setCellValueFactory( new PropertyValueFactory<>("ra") );

        TableColumn<Aluno, String> col3 = new TableColumn<>("Nome");
        col3.setCellValueFactory( new PropertyValueFactory<>("nome") );

        TableColumn<Aluno, String> col4 = new TableColumn<>("Nascimento");
        col4.setCellValueFactory( (alunoProp) -> {
            LocalDate n = alunoProp.getValue().getNascimento();
            String strData = n.format(this.dtf);
            return new ReadOnlyStringWrapper(strData);
        } );

        TableColumn<Aluno, String> col5 = new TableColumn<>("Ações");
        col5.setCellValueFactory( new PropertyValueFactory<>("DUMMY") );
        col5.setCellFactory( (tbCol) ->
                new TableCell<Aluno, String>() {
                    final Button btn = new Button("Remover");

                    public void updateItem(String item, boolean empty) {
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction( (e) -> {
                                Aluno aluno = getTableView().getItems().get(getIndex());
                                Alert alert = new Alert(Alert.AlertType.WARNING,
                                        "Você confirma a remoção do Aluno Id " +
                                                aluno.getId(), ButtonType.OK, ButtonType.CANCEL);
                                Optional<ButtonType> clicado = alert.showAndWait();
                                if (clicado.isPresent() &&
                                        clicado.get().equals(ButtonType.OK)) {
                                    control.remover(aluno.getId());
                                }
                            });
                            setGraphic(btn);
                            setText(null);
                        }
                    }
                }
        );

        table.getColumns().addAll(col1, col2, col3, col4, col5);

        table.setItems(control.getListaView());

        table
                .getSelectionModel()
                .selectedItemProperty()
                .addListener( (obs, antigo, novo) -> {
                            if (novo != null) {
                                control.setEntity(novo);
                            }
                        }
                );
    }

    @Override
    public void start(Stage stage) {
        BorderPane panPrincipal = new BorderPane();
        GridPane panCampos = new GridPane();
        txtId.setEditable(false);
        txtId.setDisable(true);
        Bindings.bindBidirectional(txtId.textProperty(), control.id, new NumberStringConverter());
        Bindings.bindBidirectional(txtRa.textProperty(), control.ra, new NumberStringConverter());
        Bindings.bindBidirectional(txtNome.textProperty(), control.nome);
        Bindings.bindBidirectional(dtNascimento.valueProperty(),
                control.nascimento);

        panCampos.add(new Label("Id"), 0, 0);
        panCampos.add(txtId, 1, 0);

        panCampos.add(new Label("Ra"), 0, 1);
        panCampos.add(txtRa, 1, 1);

        panCampos.add(new Label("Nome"), 0, 2);
        panCampos.add(txtNome, 1, 2);

        panCampos.add(new Label("Nascimento"), 0, 3);
        panCampos.add(dtNascimento, 1, 3);

        panCampos.add(btnSalvar, 0, 4);
        panCampos.add(btnPesquisar, 1, 4);

        btnSalvar.setOnAction(e -> {
            control.salvar();
        });

        btnPesquisar.setOnAction( e -> {
            control.pesquisar();
        });

        panPrincipal.setTop(panCampos);
        panPrincipal.setCenter(table);
        this.criarTabela();
        Scene scn = new Scene(panPrincipal, 600, 400);

        stage.setScene(scn);
        stage.setTitle("Gestão de Alunos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AlunoBoundary.class, args);
    }

}
