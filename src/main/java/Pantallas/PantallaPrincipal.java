package Pantallas;

import Interfaces.ControllerInterface;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;


public class PantallaPrincipal extends Application implements ControllerInterface {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        Cargar();
    }

    /*private Stage main2() {

        SecundaryStage.setTitle("Hotel Alura");

        //este metodo no se esta utilizando
        // ImagenMenu idk = new ImagenMenu();

        //este tampoco
        // BorderPane root = new BorderPane();
        //root.setCenter(idk.CargarElementos()); // Coloca el StackPane en el centro

        VBox vbox = new VBox();
        vbox.getChildren().addAll(pagina1.getRoot());
        VBox.setVgrow(app.getRoot(), Priority.ALWAYS);
        Scene scene = new Scene(vbox, 910, 939);
        String CSS = String.valueOf(getClass().getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);


        SecundaryStage.setScene(scene);
        SecundaryStage.show();

        return SecundaryStage;
    }*/


}
