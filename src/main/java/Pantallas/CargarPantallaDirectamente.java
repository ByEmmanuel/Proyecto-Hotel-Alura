package Pantallas;

import Calculadora.Calculadora;
import Controller.CargarLoginController;
import Controller.PantallaDeAcceso;
import Excepciones.ErrorLogin;
import Interfaces.ControllerInterface;
import javafx.application.Application;
import javafx.stage.Stage;

public class CargarPantallaDirectamente extends Application implements  ControllerInterface {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {


        /* // Elementos Registo
        PantallaDeAcceso pantallaDeAcceso =new PantallaDeAcceso();
        pantallaDeAcceso.cargarElementosRegistro();
        */

/*
         // Elementos Login
        PantallaDeAcceso pantalla = new PantallaDeAcceso();
        pantalla.cargarElementosLoging();
*/


/*
        // Ventana de error En forma de excepcion (Faltan mas ventanas de excepcion)
        try {
            throw new ErrorLogin();
        } catch (RuntimeException e) {
            System.out.println("Error en la ventana");    
        }
*/



/*
         // Pantalla Principal 2 (Despues del login)
        PantallaPrincipal2 pantalla = new PantallaPrincipal2();
        pantalla.CargarElementos();
*/




         //Codico morse
        PantallaPrincipal3Morse pantalla = new PantallaPrincipal3Morse();
        pantalla.CargarMorse();


/*
        // Calculadora
        try {
            throw new Calculadora();
        }catch (Exception io){
        }
        */


    }
}