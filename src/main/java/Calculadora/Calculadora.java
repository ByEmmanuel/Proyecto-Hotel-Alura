package Calculadora;


import DAO.UsuarioDAO;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends RuntimeException {


    Stage primaryStage = new Stage();
    private Label label = new Label("Número seleccionado:");



    public Calculadora() {
        VBox root = new VBox(20); // VBox para organizar los botones verticalmente con un espacio de 10 pixels entre ellos

        // Crea un HBox para cada fila de botones
        HBox row1 = new HBox(10); // HBox para la primera fila de botones
        HBox row2 = new HBox(10); // HBox para la segunda fila de botones
        HBox row3 = new HBox(10); // HBox para la tercera fila de botones

        // Agrega botones del 0 al 9 a las filas correspondientes
        for (int num = 0; num < 10; num++) {
            Button button = new Button(Integer.toString(num));

            button.setMinSize(30, 30);

            // Agrega un controlador de eventos de clic a cada botón
            button.setOnAction(event -> {
                String numero = button.getText();
                String numeroSeleccionado = ""; // Variable para mantener el número seleccionado
                numeroSeleccionado.concat(button.getText());
                label.setText("Número seleccionado: " + numeroSeleccionado);
            });
            label.getText();

            if (num < 3) {
                row1.getChildren().add(button); // Agrega botones a la primera fila
            } else if (num < 6) {
                row2.getChildren().add(button); // Agrega botones a la segunda fila
            } else {
                row3.getChildren().add(button); // Agrega botones a la tercera fila
            }
        }


        // Agrega las filas de botones al VBox principal
        root.getChildren().addAll(row1, row2, row3, label);

        // Crea el Scene y agrega el VBox principal
        Scene scene = new Scene(root, 200, 250);

        // Establece el título de la ventana
        primaryStage.setTitle("Botones Personalizados");

        // Establece la escena en el Stage y muestra la ventana
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
