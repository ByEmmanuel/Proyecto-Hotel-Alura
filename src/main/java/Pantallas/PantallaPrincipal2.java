package Pantallas;

import Controller.CargarLoginController;
import Controller.CargarRegistoController;
import DAO.UsuarioDAO;
import Interfaces.ControllerInterface;
import Persistence_JPA.JPAUsuarios;
import Persistence_JPA.JPAUtils;
import jakarta.persistence.EntityManager;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PantallaPrincipal2 implements ControllerInterface {
        public void CargarElementos(){


                UsuarioDAO usuarioDAO = new UsuarioDAO();
                //CargarLoginController LC = new CargarLoginController();
                String usuario = usuarioDAO.BuscarPorEmail("");
                // Al parecer si le pongo los valores directos si agarra
                //String usuario = usuarioDAO.BuscarPorEmail(1@1);
                primaryStage.setTitle("Bienvenido " + usuario);


                Pane pane = new Pane();

                // Crea un Label
                Label label = new Label("Texto del Label");

                // Agrega el Label al Pane proporcionado como argumento
                pane.getChildren().add(label);

                VBox vbox = new VBox();
                vbox.getChildren().addAll(controller2.getRoot());
                VBox.setVgrow(app.getRoot(), Priority.ALWAYS);
                Scene scene = new Scene(vbox, 910, 529);
                String CSS = String.valueOf(getClass().getResource("/Styles/styles.css"));
                scene.getStylesheets().add(CSS);


                primaryStage.setScene(scene);
                primaryStage.show();

        }



}

