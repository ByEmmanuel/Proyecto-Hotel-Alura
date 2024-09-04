package Pantallas;

import DAO.UsuarioDAO;
import Interfaces.ControllerInterface;
import Persistence_JPA.JPAUsuarios;
import Persistence_JPA.Reservas;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;

public class PantallasAdmin implements ControllerInterface {

    private int labelCounter = 0;
    private GridPane mainLayout;
    public void CargarReservas(){
        primaryStage.setTitle("Bienvenido Admin, Esta es la pantalla de reservas");
        Pane pane = new Pane();
        // Crea un Label
        Label label = new Label("Texto del Label");
        // Agrega el Label al Pane proporcionado como argumento
        pane.getChildren().add(label /* AQUI SE AGREGAN LOS COMPONENTES DE LA APP*/ );
        VBox vbox = new VBox();
        vbox.getChildren().addAll(CargarElementosReservas(),BotonSalir());
        VBox.setVgrow(app.getRoot(), Priority.ALWAYS);
        Scene scene = new Scene(vbox, 910, 929);
        String CSS = String.valueOf(getClass().getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void CargarUsuarios(){
        primaryStage.setTitle("Bienvenido Admin, Esta es la pantalla de Usuarios");
        Pane pane = new Pane();
        // Crea un Label
        Label label = new Label("Texto del Label");
        // Agrega el Label al Pane proporcionado como argumento
        pane.getChildren().add(label);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(CargarElementosUsuarios(),BotonSalir());
        VBox.setVgrow(app.getRoot(), Priority.ALWAYS);
        Scene scene = new Scene(vbox, 910, 529);
        String CSS = String.valueOf(getClass().getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    private Pane CargarElementosReservas() {
        mainLayout = new GridPane();
        mainLayout.setPadding(new Insets(10));

        Label greetingLabel = new Label("¡Bienvenido Admin, Este es el Panel de Reservas!");
        mainLayout.add(greetingLabel, 0, 0);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Reservas> reservas = usuarioDAO.consultarReservas();

        int rowIndex = 1; // Comenzar desde la segunda fila (fila 1) después del Label de bienvenida

        for (Reservas reserva : reservas) {
            String labelText = "Usuario: " + reserva.getUsuario()
                    + "\nId Reserva: " + reserva.getIdReserva()
                    + "\nFecha De Entrada: " + reserva.getFechaEntrada()
                    + "   ||    Fecha De Salida: " + reserva.getFechaSalida()
                    + "   ||   Forma de pago: " + reserva.getFormaDePago()
                    + "   ||    Valor: " + reserva.getValor();


            Label newLabel = new Label(labelText);


            if (reserva.getIdReserva().equals("10")) {

                mainLayout.add(newLabel, 1, mainLayout.getRowCount()); // Agregar a la columna 0 de la siguiente fila
            } else {
                mainLayout.add(newLabel, labelCounter, mainLayout.getRowCount()); // Agregar a la columna actual

            }
/*
            mainLayout.add(newLabel, 0, rowIndex); // Agregar a la columna 0 y la fila actual (variable rowIndex)


            rowIndex++;*/
        }

        return mainLayout;
    }



    private Pane CargarElementosUsuarios(){

        mainLayout = new GridPane();
        mainLayout.setPadding(new Insets(10));
        Label greetingLabel = new Label("¡Bienvenido Admin, Este es el Panel de Usuarios!");
        mainLayout.add(greetingLabel, 0, 0);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<JPAUsuarios> usuarios = usuarioDAO.consultarUsuarios();
        int rowIndex = 1; // Comenzar desde la segunda fila (fila 1) después del Label de bienvenida
        for (JPAUsuarios usuario : usuarios) {
            String labelText =  "ID: " + usuario.getId()
            + "   ||   Nombre: " + usuario.getNombre()
            + "   ||   Email: " + usuario.getEmail()
            + "   ||   Contraseña: " + usuario.getContraseña();
            Label newLabel = new Label(labelText);


            if (usuario.getId().equals("10")) {

                mainLayout.add(newLabel, 1, mainLayout.getRowCount()); // Agregar a la columna 0 de la siguiente fila
            } else {
                mainLayout.add(newLabel, labelCounter, mainLayout.getRowCount()); // Agregar a la columna actual
            }
/*
            mainLayout.add(newLabel, 0, rowIndex); // Agregar a la columna 0 y la fila actual (variable rowIndex)


            rowIndex++;*/
            }

        return mainLayout;
    }

    private Button BotonSalir() {
        Button ImgExit = new Button();
        ImgExit.setId("Boton-Exit");
        URL loginImageUrl = getClass().getResource("/imagenes/Cerrar-Sesion.png");
        Image loginImage = new Image(loginImageUrl.toString(), 32, 32, false, true);
        ImgExit.setGraphic(new ImageView(loginImage));
        ImgExit.setOnAction(Event -> {

            limpiarPantallaYCargar2();

            System.out.println("BOTON DE SALIR CLICKEADO");
        });
        // Establecer las coordenadas x e y del botón en el Pane
        ImgExit.setLayoutX(8050); // Ajusta la coordenada x según sea necesario
        ImgExit.setLayoutY(789); // Ajusta la coordenada y según sea necesario


        return ImgExit;
    }

    private void limpiarPantallaYCargar2() {
        Stage stage = (Stage) mainLayout.getScene().getWindow();
        //Stage stage = (Stage) ImgExit.getScene().getWindow(); // Obtener la ventana actual
        stage.close(); // Cerrar la ventana y, por lo tanto, la aplicación

        Cargar();
    }



}

