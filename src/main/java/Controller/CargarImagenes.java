package Controller;

import Interfaces.ControllerInterface;
import Pantallas.PantallaPrincipal;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;

public class CargarImagenes implements ControllerInterface {

    /**
     *
     * @return
     * ESTA CLASE ES LA INVOCADORA DE LAS IMAGENES
     * AQUI SE PONEN LAS IMAGENES PARA QUE SEAN LLAMADAS
     *
     */
    public Button ImgExit() {
        Button ImgExit = new Button();
        ImgExit.setId("Boton-Exit");
        URL loginImageUrl = getClass().getResource("/imagenes/cerrar-sesion 32-px.png");
        Image loginImage = new Image(loginImageUrl.toString(), 32, 32, false, true);
        ImgExit.setGraphic(new ImageView(loginImage));
        ImgExit.setOnAction(Event -> {
            Stage stage = (Stage) ImgExit.getScene().getWindow(); // Obtener la ventana actual
            stage.close(); // Cerrar la ventana y, por lo tanto, la aplicación

            System.out.println("BOTON DE SALIR CLICKEADO");
        });
        // Establecer las coordenadas x e y del botón en el Pane
        ImgExit.setLayoutX(860); // Ajusta la coordenada x según sea necesario
        ImgExit.setLayoutY(0); // Ajusta la coordenada y según sea necesario


        return ImgExit;
    }
    public Button exitLogoEnLogin() {
        Button ImgExit = new Button();
        ImgExit.setId("Boton-Exit");
        URL loginImageUrl = getClass().getResource("/imagenes/X.png");
        Image loginImage = new Image(loginImageUrl.toString(), 54, 58, false, true);
        ImgExit.setGraphic(new ImageView(loginImage));
        ImgExit.setOnAction(Event -> {
            Stage stage = (Stage) ImgExit.getScene().getWindow(); // Obtener la ventana actual
            stage.close(); // Cerrar la ventana y, por lo tanto, la aplicación

            System.out.println("BOTON DE SALIR CLICKEADO");
        });
        // Establecer las coordenadas x e y del botón en el Pane
        ImgExit.setLayoutX(690); // Ajusta la coordenada x según sea necesario
        ImgExit.setLayoutY(0); // Ajusta la coordenada y según sea necesario


        return ImgExit;
    }
    public Button ImgDefault() {
        Button ImgButton = new Button();
        ImgButton.setId("Boton-Img");
        URL loginImgUrl = getClass().getResource("/imagenes/iniciar-sesion.png");
        Image loginImage = new Image(loginImgUrl.toString(), 64, 64, false, true);
        ImgButton.setGraphic(new ImageView(loginImage));
        ImgButton.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
        ImgButton.setOnAction(Event -> {
            System.out.println("BOTON DE IMAGEN DE LOGIN CLICKEADO");
        });
        // Establecer las coordenadas x e y del botón en el Pane
        ImgButton.setLayoutX(750); // Ajusta la coordenada x según sea necesario
        ImgButton.setLayoutY(280); // Ajusta la coordenada y según sea necesario


        return ImgButton;
    }
    public Button ImgDefault2() {
        Button ImgButton = new Button();
        ImgButton.setId("Boton-Img");
        URL loginImageUrl = getClass().getResource("/imagenes/reserva.png");
        Image loginImage = new Image(loginImageUrl.toString(), 64, 64, false, true);
        ImgButton.setGraphic(new ImageView(loginImage));
        ImgButton.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
        ImgButton.setOnAction(Event -> {
            System.out.println("BOTON DE IMAGEN DE REGISTRO CLICKEADO");
        });
        // Establecer las coordenadas x e y del botón en el Pane
        ImgButton.setLayoutX(750); // Izquierda A derecha ( X )
        ImgButton.setLayoutY(400); // Arriba A Abajo ( Y )


        return ImgButton;
    }
    public ImageView BackGroudnImg() {
        URL backgroundImageUrl = getClass().getResource("/imagenes/menu_img.png");
        Image background = new Image(backgroundImageUrl.toString());
        return new ImageView(background);
    }
    public ImageView BackGroudnImgDeLogin() {
        URL backgroundImageUrl = getClass().getResource("/imagenes/login2.0.png");
        Image background = new Image(backgroundImageUrl.toString(),410, 480, false, true);
        ImageView BackGroundDeLogin = new ImageView(background);

        BackGroundDeLogin.setLayoutX(0); // Izquierda A derecha ( X )
        BackGroundDeLogin.setLayoutY(0); // Arriba A Abajo ( Y )
        return BackGroundDeLogin;
    }
    public ImageView logoHotel() {
        URL Img = getClass().getResource("/imagenes/aH-150px.png");
        Image background = new Image(Img.toString(),150, 150, false, true);
        ImageView logoHotel = new ImageView(background);
        logoHotel.setLayoutX(715); // Izquierda A derecha ( X )
        logoHotel.setLayoutY(50);  // Arriba A Abajo ( Y )
        return logoHotel;
    }
    public ImageView bienvenidaLogo() {
        URL Img = getClass().getResource("/imagenes/imgBienvenida.png");
        Image background = new Image(Img.toString(),151, 88, false, true);
        ImageView bienvenidaLogo = new ImageView(background);
        bienvenidaLogo.setLayoutX(480); // Izquierda A derecha ( X )
        bienvenidaLogo.setLayoutY(50);  // Arriba A Abajo ( Y )
        return bienvenidaLogo;
    }
    public ImageView Registrate() {
        URL Img = getClass().getResource("/imagenes/imgBienvenida.png");
        Image background = new Image(Img.toString(),151, 88, false, true);
        ImageView bienvenidaLogo = new ImageView(background);
        bienvenidaLogo.setLayoutX(480); // Izquierda A derecha ( X )
        bienvenidaLogo.setLayoutY(50);  // Arriba A Abajo ( Y )
        return bienvenidaLogo;
    }
    public ImageView BackGroudnImgDeRegistro() {
        URL backgroundImageUrl = getClass().getResource("/imagenes/registro.png");
        Image background = new Image(backgroundImageUrl.toString(),481, 519, false, true);
        ImageView BackGroundD = new ImageView(background);

        BackGroundD.setLayoutX(0); // Izquierda A derecha ( X )
        BackGroundD.setLayoutY(0); // Arriba A Abajo ( Y )
        return BackGroundD;
    }
    public ImageView FotoHotelReserva() {
        URL backgroundImageUrl = getClass().getResource("/imagenes/img-hotel-login-.png");
        Image background = new Image(backgroundImageUrl.toString(),252, 340, false, true);
        ImageView BackGroundD = new ImageView(background);
        BackGroundD.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
        BackGroundD.setLayoutX(10); // Izquierda A derecha ( X )
        BackGroundD.setLayoutY(200); // Arriba A Abajo ( Y )
        return BackGroundD;
    }
    public ImageView FondoAzul() {
        URL backgroundImageUrl = getClass().getResource("/imagenes/FondoAzul.jpg");
        Image background = new Image(backgroundImageUrl.toString(),302, 330, false, true);
        ImageView BackGroundD = new ImageView(background);
        //BackGroundD.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
        BackGroundD.setLayoutX(0); // Izquierda A derecha ( X )
        BackGroundD.setLayoutY(200); // Arriba A Abajo ( Y )
        return BackGroundD;
    }
    public ImageView FondoAzul2() {
        URL backgroundImageUrl = getClass().getResource("/imagenes/FondoAzul2.jpg");
        Image background = new Image(backgroundImageUrl.toString(),910, 100, false, true);
        ImageView BackGroundD = new ImageView(background);
        //BackGroundD.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
        BackGroundD.setLayoutX(0); // Izquierda A derecha ( X )
        BackGroundD.setLayoutY(0); // Arriba A Abajo ( Y )
        return BackGroundD;
    }


}
