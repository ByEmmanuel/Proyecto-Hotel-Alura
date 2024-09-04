package PantallaPrincipalControles;

import Controller.CargarImagenes;
import Excepciones.AsegurarRegistro;
import Interfaces.ControllerInterface;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;

public class Controller2 implements ControllerInterface {
    private Pane mainLayout;
    DatePicker fecha1 = new DatePicker(LocalDate.now());
    DatePicker fecha2 = new DatePicker(LocalDate.now());
    CargarImagenes imagenes = new CargarImagenes();
    ComboBox<String> formadepago = new ComboBox<String>();
    String formadepagotxt;
    CheckBox cajita = new CheckBox();
    String respuesta;
    TextField TextF;



    public Controller2() {

        setupUI();
    }

    private void setupUI() {
        mainLayout = new Pane();

        mainLayout.setPadding(new Insets(10));

        ImageView imgBckG = imagenes.FotoHotelReserva();
        Button ImgExit = imagenes.ImgExit();

        Label label = new Label("¡Bienvenido!");
        ImageView FondoAzul = imagenes.FondoAzul();
        ImageView FondoAzul2 = imagenes.FondoAzul2();


        mainLayout.getChildren().addAll(FondoAzul2,FondoAzul,ImgExit,ImgExit2(), imgBckG,CasillaTrabajo(),h1(),h2(),titulo1(),titulo2(),cupon(),preguntaDesc(),tarifa(),cerrarSesion(),fechaEntrada(),fechaSalida(),botonEnviar(),formadepago());
    }
    private Label h1(){
        Label h1= new Label();
        h1.setId("h1");
        h1.setText("Encuentra tu próxima estancia");



        h1.setLayoutX(20); // Izquierda a derecha ( X )
        h1.setLayoutY(10); // Arriba A Abajo ( Y )

        return h1;
    }
    private Label h2(){
        Label h2= new Label();
        h2.setId("h2");
        h2.setText("Busca ofertas en hoteles, casas y mucho más...");

        h2.setLayoutX(20); // Izquierda a derecha ( X )
        h2.setLayoutY(70); // Arriba A Abajo ( Y )

        return h2;
    }
    private Label titulo1(){
        Label titulo1 = new Label();
        titulo1.setId("TextoFechas");
        titulo1.setText("Introduce tu fecha de entrada...");

        titulo1.setLayoutX(330); // Izquierda a derecha ( X )
        titulo1.setLayoutY(130); // Arriba A Abajo ( Y )

        return titulo1;
    }
    private Label titulo2(){
        Label titulo1 = new Label();
        titulo1.setId("TextoFechas");
        titulo1.setText("Introduce tu fecha de Salida...");

        titulo1.setLayoutX(650); // Izquierda a derecha ( X )
        titulo1.setLayoutY(130); // Arriba A Abajo ( Y )

        return titulo1;
    }
    private Label cerrarSesion(){
        Label Labelx= new Label();
        Labelx.setId("TextoFechas");
        Labelx.setText("Cerrar Sesion");

        Labelx.setLayoutX(820); // Izquierda a derecha ( X )
        Labelx.setLayoutY(469); // Arriba A Abajo ( Y )

        return Labelx;
    }
    private DatePicker fechaEntrada(){
        fecha1.setId("Escoger-Fecha");
        this.fecha1.setEditable(false);
        this.fecha1.setLayoutX(330);
        this.fecha1.setLayoutY(150);

        return fecha1;
    }
    private DatePicker fechaSalida(){
        fecha2.setId("Escoger-Fecha");
        this.fecha2.setEditable(false);
        this.fecha2.setLayoutX(650);
        this.fecha2.setLayoutY(150);

        return fecha2;
    }
    private Button botonEnviar(){
        Button boton = new Button("ENVIAR");
        boton.setId("Boton-Enviar");

        boton.setOnAction(Event -> {

            calcularTarifa();
            LocalDate fechaDate1 = fecha1.getValue();
            String fechatxt1 = fechaDate1.toString();

            LocalDate fechaDate2 = fecha2.getValue();
            String fechatxt2 = fechaDate2.toString();

            formadepagotxt = this.formadepago.getValue();

            //System.out.println(fechatxt1 + "      " + fechatxt2);

            // Quitar cuando tenga que usar

            throw new AsegurarRegistro(fechatxt1, fechatxt2, formadepagotxt,calcularTarifa());

          /*  LocalDate fechaSeleccionada = fecha1.getValue();
            LocalDate fechaSel = fecha2.getValue();

            if (fechaSeleccionada != null) {
                String fechaStr = fechaSeleccionada.toString();
                System.out.println(fechaStr);
                System.out.println(fechaSel);

            } else {
                //Throw una nueva ventana
                System.out.println("No se ha seleccionado una fecha.");
            }*/
        });

        boton.setLayoutX(550);
        boton.setLayoutY(440);

        return boton;
    }
    private Button ImgExit2() {
        Button ImgExit = new Button();
        ImgExit.setId("Boton-Exit");
        URL loginImageUrl = getClass().getResource("/imagenes/Cerrar-Sesion.png");
        Image loginImage = new Image(loginImageUrl.toString(), 32, 32, false, true);
        ImgExit.setGraphic(new ImageView(loginImage));
        ImgExit.setOnAction(Event -> {

            limpiarPantallaYCargar();

            System.out.println("BOTON DE SALIR CLICKEADO");
        });
        // Establecer las coordenadas x e y del botón en el Pane
        ImgExit.setLayoutX(850); // Ajusta la coordenada x según sea necesario
        ImgExit.setLayoutY(489); // Ajusta la coordenada y según sea necesario


        return ImgExit;
    }
    private CheckBox CasillaTrabajo(){



        this.cajita.setId("formadepago");
        this.cajita.setText("¿Viajas por Trabajo?");

        this.cajita.setLayoutX(330);
        this.cajita.setLayoutY(200);


        return cajita;
    }
    private ComboBox<String> formadepago(){


        this.formadepago = new ComboBox<>();
        this.formadepago.setId("formadepago");
        this.formadepago.getItems().addAll("Tarjeta de debito", "Tarjeta de credito", "Pago en efectivo", "Transferencia Bancaria", "Cupones" );
        this.formadepago.setPromptText("Seleccionar Forma de pago");

        this.formadepago.setLayoutX(650);
        this.formadepago.setLayoutY(200);


        return formadepago;
    }
    private Label preguntaDesc(){
        Label pregunta = new Label();
        pregunta.setId("TextoFechas");
        pregunta.setText("¿Tienes algun codigo de descuento?...");

        pregunta.setLayoutX(630); // Izquierda a derecha ( X )
        pregunta.setLayoutY(240); // Arriba A Abajo ( Y )

        return pregunta;
    }
    private Label tarifa() {
        Label tarifa = new Label();
        tarifa.setId("TextoFechas");

        tarifa.textProperty().bind(Bindings.createStringBinding(() -> {
            Double tarifaCalculada = calcularTarifa();
            return "Tu Tarifa final es de...\n$" + tarifaCalculada;
        }, fecha1.valueProperty(), fecha2.valueProperty()));

        tarifa.setLayoutX(330); // Izquierda a derecha ( X )
        tarifa.setLayoutY(290); // Arriba A Abajo ( Y )

        return tarifa;
    }
    private TextField cupon(){
        TextF = new TextField();

        this.TextF.setId("Escoger-Fecha");

        this.TextF.setLayoutX(650);
        this.TextF.setLayoutY(260);

        return TextF;
    }

    /**
     *
     * @return
     * ESTE METODO CALCULA LA TARIFA DE LOS DIAS INTRODUCIDOS CON LOS DATEPICKERS
     * SI TIENE UN CODIGO DE DESCUENTO SE LE APLICARA EL 20% A SU TARIFA
     *
     */
    private Double calcularTarifa() {

        LocalDate fechaInicio = fecha1.getValue();
        LocalDate fechaFin = fecha2.getValue();

        if (fechaInicio != null && fechaFin != null && fechaInicio.isBefore(fechaFin)) {
            // Calcula la diferencia en días
            long dias = Duration.between(fechaInicio.atStartOfDay(), fechaFin.atStartOfDay()).toDays();

            // Calcula la tarifa por día (por ejemplo, $10 por día)
            double tarifaPorDia = 200.0;

            // Calcula la tarifa total
            double tarifaTotal = tarifaPorDia * dias;

            if (tieneCodigoDeDescuento()){
                double nuevaTarifa = tarifaTotal * .80;

                System.out.println("En efecto tiene codigo de descuento y su nueva tarifa es " + nuevaTarifa );
                return nuevaTarifa;
            }
            System.out.println("Tarifa Total: $" + tarifaTotal);

            return tarifaTotal;
        } else {

            System.out.println("Tarifa Total: $0.00");
            return 0.0;
        }
    }
    private boolean tieneCodigoDeDescuento(){
        if (this.TextF.getText().equals("HotelAlura2023")){
            return true;
        }else {
            return false;
        }
    }




    /**
     * ESTO NO ESTA EN IMPLEMENTACION
     * @return
     */
    public String esTrabajador(){
        this.cajita.setOnAction(event -> {
            if (this.cajita.isSelected()) {
                //usuarioDAO.EsTrabajador("Es trabajador");
                respuesta = "SI es trabajador";
            } else {
                //usuarioDAO.EsTrabajador("No es trabajador");
                respuesta = "NO es trabajador";
            }
        });
        return respuesta;
    }



    public Pane getRoot() {
        return mainLayout;
    }
}
