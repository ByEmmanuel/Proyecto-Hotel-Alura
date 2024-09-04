package Excepciones;

import DAO.UsuarioDAO;
import PantallaPrincipalControles.Controller3;
import Pantallas.PantallasAdmin;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class VentanaAdmin extends RuntimeException{

    public VentanaAdmin() {
        Pane miniPane = new Pane();
        Stage miniStage = new Stage();
        miniStage.setTitle("Login Correcto-Bienvenido Admin");

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 460, 210);
        String CSS = String.valueOf(getClass().getResource("/Styles/styles.css"));

        miniPane.getChildren().addAll(Msg(), botonReservas(),botonUsuarios(),ImgHappy());
        vbox.getChildren().addAll(miniPane);
        scene.getStylesheets().add(CSS);
        miniStage.setScene(scene);
        miniStage.show();

    }

    public VentanaAdmin(String mensaje) {
        super(mensaje);
    }

    private Label Msg() {
        Label Errormsg = new Label();
        Errormsg.setId("MensajeErrorLogin");
        Errormsg.setText("!Bienvenido¡. \n Seleccione su Operacion");

        Errormsg.setLayoutX(30);
        Errormsg.setLayoutY(50);

        return Errormsg;
    }

    private Button botonReservas() {
        Button BotonReservas = new Button("Reservas");
        BotonReservas.setId("OK");
        BotonReservas.setOnAction(event -> {

            Stage stage = (Stage) BotonReservas.getScene().getWindow(); // Obtener la ventana actual
            stage.close(); // Cerrar la ventana y, por lo tanto, la aplicación

            PantallasAdmin pantallasAdmin = new PantallasAdmin();
            pantallasAdmin.CargarReservas();



        });

        BotonReservas.setLayoutY(150);
        BotonReservas.setLayoutX(240);
        return BotonReservas;
    }
    private Button botonUsuarios() {
        Button BotonUsuarios = new Button("Usuarios");
        BotonUsuarios.setId("OK");
        BotonUsuarios.setOnAction(event -> {


            Stage stage = (Stage) BotonUsuarios.getScene().getWindow(); // Obtener la ventana actual
            stage.close(); // Cerrar la ventana y, por lo tanto, la aplicación
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            PantallasAdmin pantallasAdmin = new PantallasAdmin();
            pantallasAdmin.CargarUsuarios();

        });

        BotonUsuarios.setLayoutY(150);
        BotonUsuarios.setLayoutX(70);
        return BotonUsuarios;
    }

    public ImageView ImgHappy() {
        ImageView ImgSad = new ImageView();
        // Cargar la imagen desde el recurso
        URL loginImageUrl = getClass().getResource("/imagenes/CaritaF.png");
        Image loginImage = new Image(loginImageUrl.toString());

        // Establecer el tamaño de la imagen en el ImageView
        ImgSad.setImage(loginImage);
        ImgSad.setFitWidth(64);
        ImgSad.setFitHeight(64);
        ImgSad.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");

        // Establecer las coordenadas x e y del botón en el Pane
        ImgSad.setLayoutX(350);
        ImgSad.setLayoutY(60);

        return ImgSad;
    }
}

