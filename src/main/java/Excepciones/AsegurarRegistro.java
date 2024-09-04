package Excepciones;

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
import java.time.LocalDate;

public class AsegurarRegistro extends RuntimeException{


    public AsegurarRegistro(String x, String y, String z, double v) {
        Pane miniPane = new Pane();
        Stage miniStage = new Stage();
        miniStage.setTitle("¿Confirmar Registro?");

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 460, 210);
        String CSS = String.valueOf(getClass().getResource("/Styles/styles.css"));

        miniPane.getChildren().addAll(Msg(), botonOK(x,y,z,v),botonCancelar(),ImgHappy());
        vbox.getChildren().addAll(miniPane);
        scene.getStylesheets().add(CSS);
        miniStage.setScene(scene);
        miniStage.show();

    }

    public AsegurarRegistro(String mensaje) {
        super(mensaje);
    }

    private Label Msg() {
        Label Errormsg = new Label();
        Errormsg.setId("MensajeErrorLogin");
        Errormsg.setText("Esta Seguro de \nQuerer Concluir La reseva?");

        Errormsg.setLayoutX(30);
        Errormsg.setLayoutY(50);

        return Errormsg;
    }


    private Button botonOK(String fechaEntrada, String fechaSalida, String formadepago, double valor) {
        Button BotonOK = new Button("OK");
        BotonOK.setId("OK");
        BotonOK.setOnAction(event -> {

            System.out.println("La fecha de Entrada es; " + fechaEntrada);
            System.out.println("La fecha de Salida es; " + fechaSalida);
            System.out.println("La forma de pago es; " + formadepago);



            UsuarioDAO usuarioDAO = new UsuarioDAO();

            usuarioDAO.guardarReserva(
                    fechaEntrada,
                    fechaSalida,
                    formadepago,
                    valor
            );


            Stage stage = (Stage) BotonOK.getScene().getWindow(); // Obtener la ventana actual
            stage.close(); // Cerrar la ventana y, por lo tanto, la aplicación
        });

        BotonOK.setLayoutY(150);
        BotonOK.setLayoutX(240);
        return BotonOK;
    }

    private Button botonCancelar() {
        Button BotonOK = new Button("Cancelar");
        BotonOK.setId("Cancelar");
        BotonOK.setOnAction(event -> {


            Stage stage = (Stage) BotonOK.getScene().getWindow(); // Obtener la ventana actual
            stage.close(); // Cerrar la ventana y, por lo tanto, la aplicación
        });

        BotonOK.setLayoutY(150);
        BotonOK.setLayoutX(70);
        return BotonOK;
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



