package Interfaces;

import PantallaPrincipalControles.Controller2;

import PantallaPrincipalControles.Controller;
import PantallaPrincipalControles.Controller3;
import Pantallas.PantallaPrincipal;
import Pantallas.PantallaPrincipal2;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public interface ControllerInterface extends MetodosFX {

    Controller app = new Controller();
    Controller2 controller2 = new Controller2();
    Controller3 controller3 = new Controller3();

    /**
     * Talvez esto esta ocasionando que se borre,y al momento
     * de llamar de nuevo a la pantalla, este vacia
     * EN  EFECTO, ESTA FUNCION HACE QUE LA PANTALLA ESTE VACIA Y NO PUEDA
     * VOLVER A CARGAR LOS ELEMENTOS
     *
     * @RETURN-ERROR
     *
     */
    default void limpiarPantalla() {
            app.getRoot().getChildren().clear();
        System.out.println("USO D LIMPIAR PANTALLA EN INTERFACE");
    }
    default void limpiarPantallaYCargar() {
        //controller2.getRoot().getChildren().clear();
        Stage stage = (Stage) controller2.getRoot().getScene().getWindow();
        //Stage stage = (Stage) ImgExit.getScene().getWindow(); // Obtener la ventana actual
        stage.close(); // Cerrar la ventana y, por lo tanto, la aplicación

        Cargar();

        System.out.println("USO D LIMPIAR PANTALLA 2 EN INTERFACE");
    }
    default  void cargaPantalla2(){
        PantallaPrincipal2 queHacerPantalla = new PantallaPrincipal2();
        queHacerPantalla.CargarElementos();
    }


     default void Cargar() {
        main();
    }
     default Stage main(){

        primaryStage.setTitle("Hotel Alura");

        VBox vbox = new VBox();
        vbox.getChildren().addAll(app.getRoot());
        VBox.setVgrow(app.getRoot(), Priority.ALWAYS);
        Scene scene = new Scene(vbox, 910, 539);
        String CSS = String.valueOf(getClass().getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);


        primaryStage.setScene(scene);
        primaryStage.show();

        return primaryStage;
    }



}
