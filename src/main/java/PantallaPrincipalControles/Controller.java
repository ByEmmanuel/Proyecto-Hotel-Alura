package PantallaPrincipalControles;


import Controller.CargarImagenes;
import Interfaces.ControllerInterface;
import Controller.PantallaDeAcceso;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Controller implements ControllerInterface {

    //Al prinipio se cargan todos los elementos y de donde se van a llamar

    CargarImagenes imagenes = new CargarImagenes();
    private Pane mainLayout;

    // Despues se cargarn las entidades

    public Controller() {

        setupUI();
    }

    private void setupUI() {
        mainLayout = new Pane();

        mainLayout.setPadding(new Insets(10));

        Label greetingLabel = new Label("¡Bienvenido!");

        Button imgDefault = imagenes.ImgDefault();
        Button imgDefault2 = imagenes.ImgDefault2();
        ImageView BckImg = imagenes.BackGroudnImg();
        Button ImgExit = imagenes.ImgExit();
        ImageView imgLogoHotel = imagenes.logoHotel();


        mainLayout.getChildren().addAll(BckImg,ImgExit,imgLogoHotel,limpiarButton(), botonLogin() , BotonRegistrar(),greetingLabel, imgDefault, imgDefault2);
    }



    private Button botonLogin(){
        Button loginButton = new Button("LOGIN");
        loginButton.setId("Boton-Login-main");

        loginButton.setOnAction(Event -> {
            PantallaDeAcceso nuevaPantalla = new PantallaDeAcceso();
            nuevaPantalla.cargarElementosLoging();
            System.out.println("BOTON LOGIN CLICKEADO");
        });
        loginButton.setLayoutX(750); // Izquierda A derecha ( X )
        loginButton.setLayoutY(240); // Arriba A Abajo ( Y )

        return loginButton;
    }

    private Button BotonRegistrar(){
        Button loginButton = new Button("REGISTRATE");
        loginButton.setId("Boton-Registrar");

        loginButton.setOnAction(Event -> {
            PantallaDeAcceso nuevaPantalla = new PantallaDeAcceso();
            nuevaPantalla.cargarElementosRegistro();
            System.out.println("BOTON REGISTRO CLICKEADO");
        });
        loginButton.setLayoutX(725); // Izquierda A derecha ( X )
        loginButton.setLayoutY(360); // Arriba A Abajo ( Y )

        return loginButton;
    }

    private Button limpiarButton(){
        Button limpiarButton = new Button("Limpiar");
        limpiarButton.setId("Boton-Registrar");

        limpiarButton.setOnAction(Event -> {
            limpiarPantalla(); //limpiar desde la interfaz
        });

        return limpiarButton;
    }

    //Y por ultimo las funciones

    @Override
    public void limpiarPantalla() {
        ControllerInterface.super.limpiarPantalla();
    }

    public Pane getRoot() {
        return mainLayout;
    }

}

