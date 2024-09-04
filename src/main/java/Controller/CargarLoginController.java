package Controller;


import DAO.UsuarioDAO;
import Excepciones.ErrorLogin;
import Excepciones.VentanaAdmin;
import Interfaces.ControllerInterface;
import Persistence_JPA.JPAUsuarios;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.util.List;


public class CargarLoginController implements ControllerInterface {

    /**
     *
     * ESTA CLASE ES EL CONTROLLADOR DE LOGIN
     *
      */
    private Pane mainLayout;

    private final PasswordField password = new PasswordField();
    private static final TextField emailLogin = new TextField();

    private Label MostrarContraseña;

    public CargarLoginController(){
        try {
            setupID();
        } catch (Exception e) {}
    }

    private void setupID() throws Exception {

        this.mainLayout = new Pane();

        mainLayout.getChildren().addAll(botonLogin(),Email(),Password(),SeeOrNot(),MostrarPassword());


    }

    private TextField Email(){

        emailLogin.setPromptText("Ingrese Email o Usuario");
        emailLogin.setId("Label-Email");

        emailLogin.setLayoutX(480);
        emailLogin.setLayoutY(170);
        return emailLogin;
    }
    private PasswordField Password(){
        password.setPromptText("Ingrese Contraseña");
        password.setId("Label-Password");

        password.setLayoutX(480);
        password.setLayoutY(200);

        password.textProperty().addListener((observable) -> {
            // Actualizar el campo de contraseña en tiempo real
            this.MostrarContraseña.setText("");

        });

        return password;
    }
    private Label MostrarPassword(){
         this.MostrarContraseña= new Label();
        MostrarContraseña.setText("");

        MostrarContraseña.setLayoutX(484);
        MostrarContraseña.setLayoutY(230);


        return MostrarContraseña;
    }

    private ToggleButton SeeOrNot(){
        ToggleButton SeeOrNot = new ToggleButton("Mostrar");
        SeeOrNot.setOnAction(event -> {

            this.MostrarContraseña.setText(password.getText());
            System.out.println(this.password.getText());
            if (SeeOrNot.isSelected()) {
                //this.password.setPromptText(this.password.getText());
                password.textProperty().addListener((observable, oldValue, newValue) -> {
                    // Actualizar el campo de contraseña en tiempo real
                    this.MostrarContraseña.setText(newValue);
                    System.out.println("Contraseña actualizada: " + newValue);
                    //no terminado/bug
                    if(SeeOrNot.isSelected() && MostrarContraseña != null){
                    }
                });
            } else  {
                this.MostrarContraseña.setText("");
                System.out.println("HOLAAA");
                clearConsole();
            }
        });

        SeeOrNot.setLayoutY(200);
        SeeOrNot.setLayoutX(650);
        return SeeOrNot;
    }

    public Button botonLogin(){
        Button loginButton = new Button("LOGIN");

        loginButton.setId("Boton-Login");

        loginButton.setOnAction(Event -> {


                // Obtener el correo electrónico y la contraseña ingresados por el usuario
                String emailText = emailLogin.getText(); // Suponiendo que emailTextField es tu campo de correo electrónico
                String contraseñaText = password.getText(); // Suponiendo que contraseñaPasswordField es tu campo de contraseña

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            List<JPAUsuarios> usuariosEncontrados = usuarioDAO.buscarPorEmailYContraseña(emailLogin.getText(),password.getText());

                if (usuarioDAO.esAdmin(emailText, contraseñaText)){
                    System.out.println("ADMIN LOGEADO - Clase CargarLoginController");
                    Stage stage = (Stage) loginButton.getScene().getWindow(); // Obtener la ventana actual

                    stage.close(); // Cerrar la ventana
                    throw new VentanaAdmin();
                } else if (!usuariosEncontrados.isEmpty()) {

                    // Credenciales válidas: El usuario existe en la base de datos y las credenciales coinciden.
                    // Realiza las acciones necesarias aquí, como iniciar sesión o redirigir al usuario.

                    // Por ejemplo, puedes mostrar un mensaje de éxito
                    Stage stage = (Stage) loginButton.getScene().getWindow(); // Obtener la ventana actual

                    stage.close(); // Cerrar la ventana
                    System.out.println("ACCESO CORRECTO");

                    cargaPantalla2();
                    System.out.println("EXITO");

                    // Luego, puedes cerrar la ventana de inicio de sesión o redirigir al usuario a otra página.
                    // Por ejemplo:
                    // Stage stage = (Stage) loginButton.getScene().getWindow(); // Obtener la ventana actual
                    // stage.close(); // Cerrar la ventana de inicio de sesión

                } else {
                    // Credenciales no válidas: No se encontraron usuarios con las credenciales proporcionadas.
                    // Mostrar un mensaje de error al usuario.
                    // Cerrar el EntityManager

                    System.out.println("Algo salio mal");
                    throw new ErrorLogin(); 
                }

            System.out.println("BOTON LOGIN EN PANTALLA DE LOGIN CLICKEADO");
            });
        loginButton.setLayoutX(435); // Ajusta la coordenada x según sea necesario
        loginButton.setLayoutY(250); // Ajusta la coordenada y según sea necesario

        return loginButton;
        }

    public PasswordField getPassword() {
        return password;
    }
    public TextField getEmailLogin() {
        return emailLogin;
    }


    private void clearConsole() {
        MostrarContraseña.setText("");

    }

    public static String getEmail() {
        return emailLogin.getText();
    }




    public Pane getRoot() {
        return mainLayout;
    }
}


