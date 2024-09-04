package Pantallas;

import Interfaces.ControllerInterface;
import PantallaPrincipalControles.ControllerMorseCode;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PantallaPrincipal3Morse implements ControllerInterface {


    public void CargarMorse(){
        ControllerMorseCode controllermorse = new ControllerMorseCode();
        primaryStage.setTitle("codigo morse");
        Pane pane = new Pane();

        // Crea un Label
        Label label = new Label("Texto del Label");

        // Agrega el Label al Pane proporcionado como argumento
        pane.getChildren().add(label);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(controllermorse.getRoot());
        VBox.setVgrow(app.getRoot(), Priority.ALWAYS);
        Scene scene = new Scene(vbox, 910, 539);
        String CSS = String.valueOf(getClass().getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);


        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
