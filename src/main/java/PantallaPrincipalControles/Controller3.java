package PantallaPrincipalControles;

import Interfaces.ControllerInterface;
import Interfaces.MetodosFX;
import Pantallas.PantallaPrincipal;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class Controller3 implements ControllerInterface {
    private Pane mainLayout;

    /**
     *
     *
     *
     * @Nota
     * Esta Clase esta en des-uso  / no implementacion
     *
     *
     *
     *
     *
     */




    public void CargarReservas(){
        mainLayout = new Pane();

        mainLayout.setPadding(new Insets(10));

        Label greetingLabel = new Label("¡Bienvenido Admin, Este es el Panel de Reservas!");
        mainLayout.getChildren().addAll(greetingLabel);
    }

    public void CargarUsuarios(){
        mainLayout = new Pane();

        mainLayout.setPadding(new Insets(10));

        Label greetingLabel = new Label("¡Bienvenido Admin, Este es el Panel de Usuarios!");
        mainLayout.getChildren().addAll(greetingLabel);
    }




    public Pane getRoot() {
        return mainLayout;
    }
}
