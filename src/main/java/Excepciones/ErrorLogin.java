package Excepciones;

import java.net.URL;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ErrorLogin extends RuntimeException {

    public ErrorLogin() {
        Pane miniPane = new Pane();
        Stage miniStage = new Stage();
        miniStage.setTitle("Error en Campos");

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 460, 210);
        String CSS = String.valueOf(getClass().getResource("/Styles/styles.css"));

        miniPane.getChildren().addAll(Errormsg(), botonOK(),ImgSad());
        vbox.getChildren().addAll(miniPane);
        scene.getStylesheets().add(CSS);
        miniStage.setScene(scene);
        miniStage.show();

    }

    public ErrorLogin(String mensaje) {
        super(mensaje);
    }

    private Label Errormsg() {
        Label Errormsg = new Label();
        Errormsg.setId("MensajeErrorLogin");
        Errormsg.setText("Error. \nEmail o Contraseña Incorrectos");
        
        Errormsg.setLayoutX(30);
        Errormsg.setLayoutY(50);

        return Errormsg;
    }

    private Button botonOK() {
        Button BotonOK = new Button("OK");
        BotonOK.setId("OK");
        BotonOK.setOnAction(event -> {
            Stage stage = (Stage) BotonOK.getScene().getWindow(); // Obtener la ventana actual
            stage.close(); // Cerrar la ventana y, por lo tanto, la aplicación

        });

        BotonOK.setLayoutY(150);
        BotonOK.setLayoutX(150);
        return BotonOK;
    }

    public ImageView ImgSad() {
        ImageView ImgSad = new ImageView();
        // Cargar la imagen desde el recurso
        URL loginImageUrl = getClass().getResource("/imagenes/triste.png");
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
