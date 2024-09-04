package Controller;


import DAO.UsuarioDAO;
import Excepciones.ErrorRegistroContraseña;
import Excepciones.ErrorRegistroEmail;
import Excepciones.RegistroCorrecto;
import Interfaces.ControllerInterface;

import DAO.DataBasePruebasDAO;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;


public class CargarRegistoController implements ControllerInterface {

    /**
     * ESTA CLASE ES EL CONTROLLER DE REGISTRO
     */
    private Pane mainLayout;

    private PasswordField password = new PasswordField();
    private TextField nombre = new TextField();
    private TextField email = new TextField();
    private TextField fechaDeNacimiento = new TextField();
    private TextField nacionalidad = new TextField();
    private TextField telefono = new TextField();



    private Label MostrarContraseña;

    public CargarRegistoController(){

        setupID();
    }

    private void setupID() {

        this.mainLayout = new Pane();

        mainLayout.getChildren().addAll(botonRegistro(),
                Nombre(),
                Email(),
                Password(),
                //SeeOrNot(),
                MostrarPassword(),
                FechaDeNacimiento(),
                nacionalidad(),
                telefono());
    }

    private TextField Nombre(){

        nombre.setPromptText("Ingrese Nombre");
        nombre.setId("Label-Nombre");

        nombre.setLayoutX(480);
        nombre.setLayoutY(150);
        return nombre;
    }
    private TextField Email(){

        email.setPromptText("Ingrese Email o Usuario");
        email.setId("Label-Email");

        email.setLayoutX(480);
        email.setLayoutY(180);
        return email;
    }
    private PasswordField Password(){
        password.setPromptText("Ingrese Contraseña");
        password.setId("Label-Password");


        password.textProperty().addListener((observable) -> {
            // Actualizar el campo de contraseña en tiempo real
            this.MostrarContraseña.setText("");

        });
        password.setLayoutX(480);
        password.setLayoutY(210);

        return password;
    }
    private Label MostrarPassword(){
         this.MostrarContraseña= new Label();
        MostrarContraseña.setText("");

        MostrarContraseña.setLayoutX(480);
        MostrarContraseña.setLayoutY(240);


        return MostrarContraseña;
    }
    private TextField FechaDeNacimiento(){

        fechaDeNacimiento.setPromptText("Ingrese FechaDeNacimiento");
        fechaDeNacimiento.setId("Label-FechaDeNacimiento");

        fechaDeNacimiento.setLayoutX(480);
        fechaDeNacimiento.setLayoutY(270);
        return fechaDeNacimiento;
    }
    private TextField nacionalidad(){

        nacionalidad.setPromptText("Ingrese nacionalidad");
        nacionalidad.setId("Label-nacionalidad");

        nacionalidad.setLayoutX(480);
        nacionalidad.setLayoutY(300);
        return nacionalidad;
    }
    private TextField telefono(){

        telefono.setPromptText("Ingrese telefono");
        telefono.setId("Label-telefono");

        telefono.setLayoutX(480);
        telefono.setLayoutY(330);
        return telefono;
    }


    /**
     *
     * @return
     * BOTON PARA VER LA CONTRASEÑA Y VER QUE ESTAS INTRODUCIENDO
     */
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


    /**
     * @return
     * ALGORITMO DE REGISTRO
     */
    public Button botonRegistro(){
        Button RegistroButton = new Button("REGISTRO");

        RegistroButton.setId("Boton-Registro");

        RegistroButton.setOnAction(Event -> {

            System.out.println("BOTON Registro EN PANTALLA DE LOGIN CLICKEADO");
            boolean a = email.getText().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
            boolean e = password.getText().matches("^[a-zA-Z0-9_.-].{4,}$");
            if (!a){
                System.out.println("Formato de email invalido");
                throw new ErrorRegistroEmail();
            }else if (!e){
                System.out.println("Formato de contraseña invalido");
                throw new ErrorRegistroContraseña();
            }else {

                UsuarioDAO usuarioDAO =new UsuarioDAO();
                usuarioDAO.RegistrarUsuario(
                        nombre.getText(),
                        email.getText(),
                        password.getText(),
                        fechaDeNacimiento.getText(),
                        nacionalidad.getText(),
                        telefono.getText()
                );
            throw new RegistroCorrecto();
            }



            // Verificar las credenciales
            //boolean credencialesValidas = usuarioDAO.verificarCredenciales(emailText, contraseñaText);
           /*
            if(credencialesValidas){
                dataBaseDTO.RegistrarUsuario();
                System.out.println("REGISTRO ECITOSO");
                    // Credenciales válidas: El usuario existe en la base de datos y las credenciales coinciden.
                    // Realiza las acciones necesarias aquí, como iniciar sesión o redirigir al usuario
                    // Por ejemplo, mostrar un mensaje de éxito
                    Stage stage = (Stage) RegistroButton.getScene().getWindow(); // Obtener la ventana actual
                    limpiarPantalla();
                    stage.close(); // Cerrar la ventana
                    cargaPantalla2();
                    System.out.println("EXITO");

                    // Credenciales no válidas: No se encontraron usuarios con las credenciales proporcionadas.
                    // Puedes mostrar un mensaje de error al usuario.
            }else {
                System.out.println("Algo estuvo mal");
            }
*/
            });

           /* if (dataBaseDTO.BuscarLogin()) {
            Stage stage = (Stage) loginButton.getScene().getWindow(); // Obtener la ventana actual
            limpiarPantalla();
            stage.close(); // Cerrar la ventana
                System.out.println("ACCESO CORRECTO");

            cargaPantalla2();
            }else {
                throw new RuntimeException();
            }*/


        RegistroButton.setLayoutX(475);
        RegistroButton.setLayoutY(420);

        return RegistroButton;
        };


    private void clearConsole() {
        MostrarContraseña.setText("");

    }
    public String getNombre() {
        return nombre.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento.getText();
    }
    public String getNacionalidad() {
        return nacionalidad.getText();
    }

    public String getTelefono() {
        return telefono.getText();
    }


    public Pane getRoot() {
        return mainLayout;
    }
}


