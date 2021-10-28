package ex14;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class Botao extends Application {

    public void start(Stage stage)
    {
        stage.setTitle("Teste de eventos");
        Pane pan = new Pane();
        Scene sc = new Scene(pan, 600, 300);

        Button btnOk = new Button("Ok");
        btnOk.relocate(300, 200);

        Label lblTxt = new Label("Texto");
        lblTxt.relocate(300, 100);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                System.out.println("Hello world");
            }
        };

        btnOk.setOnAction(event);

        pan.getChildren().addAll(btnOk, lblTxt);

        stage.setScene(sc);

        stage.show();
    }

    public static void main(String args[])
    {
        launch(args);
    }
}
