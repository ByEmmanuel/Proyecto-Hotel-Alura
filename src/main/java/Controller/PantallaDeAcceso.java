package Controller;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PantallaDeAcceso {

    /**
     * ESTA CLASE ES DE DONDE SE LLAMAN A LOS CONTROLADORES
     * LOGIN O REGISTRO
     */
    CargarImagenes imagenes = new CargarImagenes();
    private Pane mainLayout;
    public void cargarElementosLoging() {

        CargarLoginController cargarLogin = new CargarLoginController();

        mainLayout = new Pane();

        mainLayout.setPadding(new Insets(10));

        Label greetingLabel = new Label("¡Login!");

        Stage SecundaryStage = new Stage();

        SecundaryStage.setTitle("Ventana de Login");

        ImageView BckImg = imagenes.BackGroudnImgDeLogin();
        ImageView BienvenidaLogo = imagenes.bienvenidaLogo();
        Button exitButton = imagenes.exitLogoEnLogin();
        Button LAO = imagenes.ImgExit();
        //Metodos en desuso
        BorderPane root = new BorderPane();
        VBox vbox = new VBox();

        mainLayout.getChildren().addAll(BckImg,exitButton,greetingLabel,BienvenidaLogo, cargarLogin.getRoot());
        Scene scene = new Scene(mainLayout, 750, 480);

        String CSS = String.valueOf(getClass().getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        SecundaryStage.setScene(scene);
        SecundaryStage.show();
    }

    public void cargarElementosRegistro() {
        CargarRegistoController cargarRegistoController = new CargarRegistoController();

        mainLayout = new Pane();

        mainLayout.setPadding(new Insets(10));

        Label greetingLabel = new Label("¡Registro!");

        Stage SecundaryStage = new Stage();

        SecundaryStage.setTitle("Ventana de Registro");

        ImageView BckImgRegistro = imagenes.BackGroudnImgDeRegistro();
        ImageView BienvenidaLogo = imagenes.Registrate();
        Button exitButton = imagenes.exitLogoEnLogin();
        Button LAO = imagenes.ImgExit();

        BorderPane root = new BorderPane();

        VBox vbox = new VBox();


        mainLayout.getChildren().addAll(BckImgRegistro,BienvenidaLogo,exitButton, cargarRegistoController.getRoot());
        Scene scene = new Scene(mainLayout, 750, 480);
        String CSS = String.valueOf(getClass().getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        SecundaryStage.setScene(scene);
        SecundaryStage.show();
    }
}
