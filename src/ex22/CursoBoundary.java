package ex22;

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

public class CursoBoundary extends Application {

    private TextField txtId = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtDescricao = new TextField();
    private TextField txtAtivo = new TextField();
    private DatePicker dtInicio = new DatePicker();
    private DatePicker dtTermino = new DatePicker();

    private Button btnNovoCurso = new Button("Novo Curso");
    private Button btnSalvar = new Button("Salvar");
    private Button btnPesquisar = new Button("Pesquisar");

    private CursoControl control = new CursoControl();

    private TableView<Curso> table = new TableView<>();

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private void criarTabela() {

        TableColumn<Curso, Long> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory( new PropertyValueFactory<>("id") );

        TableColumn<Curso, String> col2 = new TableColumn<>("Nome");
        col2.setCellValueFactory( new PropertyValueFactory<>("nome") );

        TableColumn<Curso, String> col3 = new TableColumn<>("Descrição");
        col3.setCellValueFactory( new PropertyValueFactory<>("descricao") );

        TableColumn<Curso, Boolean> col4 = new TableColumn<>("Ativo");
        col4.setCellValueFactory( new PropertyValueFactory<>("ativo") );

        TableColumn<Curso, String> col5 = new TableColumn<>("Início");
        col5.setCellValueFactory( (cursoProp1) -> {
            LocalDate n1 = cursoProp1.getValue().getInicio();
            String strData1 = n1.format(this.dtf);
            return new ReadOnlyStringWrapper(strData1);
        } );

        TableColumn<Curso, String> col6 = new TableColumn<>("Termino");
        col6.setCellValueFactory( (cursoProp2) -> {
            LocalDate n2 = cursoProp2.getValue().getTermino();
            String strData2 = n2.format(this.dtf);
            return new ReadOnlyStringWrapper(strData2);
        } );

        TableColumn<Curso, String> col7 = new TableColumn<>("Ações");
        col7.setCellValueFactory( new PropertyValueFactory<>("DUMMY") );
        col7.setCellFactory( (tbCol) ->
                new TableCell<Curso, String>() {
                    final Button btn = new Button("Remover");

                    public void updateItem(String item, boolean empty) {
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction( (e) -> {
                                Curso curso = getTableView().getItems().get(getIndex());
                                Alert alert = new Alert(Alert.AlertType.WARNING,
                                        "Você confirma a remoção do Curso Id " +
                                                curso.getId(), ButtonType.OK, ButtonType.CANCEL);
                                Optional<ButtonType> clicado = alert.showAndWait();
                                if (clicado.isPresent() &&
                                        clicado.get().equals(ButtonType.OK)) {
                                    control.remover(curso.getId());
                                }
                            });
                            setGraphic(btn);
                            setText(null);
                        }
                    }
                }
        );

        table.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7);

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
        Bindings.bindBidirectional(txtNome.textProperty(), control.nome);
        Bindings.bindBidirectional(txtDescricao.textProperty(), control.descricao);
//        Bindings.bindBidirectional(txtAtivo.getText(), control.ativo);
        Bindings.bindBidirectional(dtInicio.valueProperty(),
                control.inicio);
        Bindings.bindBidirectional(dtTermino.valueProperty(),
                control.termino);

        panCampos.add(new Label("Id"), 0, 0);
        panCampos.add(txtId, 1, 0);
        panCampos.add(btnNovoCurso, 2, 0);

        panCampos.add(new Label("Nome"), 0, 1);
        panCampos.add(txtNome, 1, 1);

        panCampos.add(new Label("Descrição"), 0, 2);
        panCampos.add(txtDescricao, 1, 2);

        panCampos.add(new Label("Ativo"), 0, 3);
//        panCampos.add(txtPeso, 1, 3);

        panCampos.add(new Label("Data de Início"), 0, 4);
        panCampos.add(dtInicio, 1, 4);

        panCampos.add(new Label("Data de Término"), 0, 5);
        panCampos.add(dtTermino, 1, 5);

        panCampos.add(btnSalvar, 0, 6);
        panCampos.add(btnPesquisar, 1, 6);

        btnSalvar.setOnAction(e -> {
            control.adicionar();
        });

        btnPesquisar.setOnAction( e -> {
            control.pesquisarPorNome();
        });

        btnNovoCurso.setOnAction( e -> {
            control.novoCurso();
        });

        panPrincipal.setTop(panCampos);
        panPrincipal.setCenter(table);
        this.criarTabela();
        Scene scn = new Scene(panPrincipal, 600, 400);

        stage.setScene(scn);
        stage.setTitle("Gestão de Cursos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(CursoBoundary.class, args);
    }

}
