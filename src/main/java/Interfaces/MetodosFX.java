package Interfaces;

import Controller.CargarLoginController;
import Controller.CargarRegistoController;
import DAO.UsuarioDAO;
import PantallaPrincipalControles.Controller;
import Persistence_JPA.Reservas;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public interface MetodosFX {
    Stage primaryStage =  new Stage();


    CargarLoginController controllerLogin = new CargarLoginController();

    CargarRegistoController controllerRegistro = new CargarRegistoController();

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Reservas reservas = new Reservas();





}
