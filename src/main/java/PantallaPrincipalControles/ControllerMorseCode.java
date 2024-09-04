package PantallaPrincipalControles;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;

public class ControllerMorseCode {
    private Pane mainLayout;


    public ControllerMorseCode() {
        SetupIU();
    }

    public void SetupIU() {
        mainLayout = new Pane();

        mainLayout.setPadding(new Insets(10));

        Label greetingLabel = new Label("¡Bienvenido!");
        mainLayout.getChildren().addAll(h1(), texto(), Calcular(), Codigo(),CalcularTexto(),textoTraducido(),CodigoAtexto());
    }


    private Label h1() {
        Label h1 = new Label();
        h1.setId("h1");
        h1.setText("Codificador de texto a codigo morse");


        h1.setLayoutX(50); // Izquierda a derecha ( X )
        h1.setLayoutY(50); // Arriba A Abajo ( Y )

        return h1;
    }

    TextField Texto = new TextField();
    TextField TextoTraducido = new TextField();

    private TextField texto() {

        this.Texto.setPromptText("Ingrese Palabras");

        this.Texto.setLayoutX(100);
        this.Texto.setLayoutY(100);

        return Texto;
    }
    private TextField textoTraducido() {

        this.TextoTraducido.setPromptText("Ingrese Codigo morse");

        this.TextoTraducido.setLayoutX(380);
        this.TextoTraducido.setLayoutY(100);

        return TextoTraducido;
    }

    Button Calcular() {
        Button Calcular = new Button("Calcular");
        Calcular.setOnAction(event -> {
            boolean a = this.Texto.getText().matches("^[a-zA-Z]");
            String morseCode = Texto.getText();
            String text = textToMorse(morseCode);

            System.out.println("Texto traducido: " + text);
            Codigo.setText(text);
            //String e = this.Texto.getText().toString();
            //Codigo.setText(e);
            //System.out.println(a);

        });


        Calcular.setLayoutX(200);
        Calcular.setLayoutY(200);

        return Calcular;
    }

    Button CalcularTexto() {
        Button Calcular = new Button("Calcular");
        Calcular.setOnAction(event -> {

            String morseCode = this.TextoTraducido.getText();
            String text = morseToText(morseCode);

            //String e = this.TextoTraducido.getText().toString();
            CodigoTraducido.setText(text);
            System.out.println(text);

        });


        Calcular.setLayoutX(380);
        Calcular.setLayoutY(200);

        return Calcular;
    }
    TextField Codigo = new TextField();
    TextField CodigoTraducido = new TextField();

    TextField Codigo() {

        this.Codigo.setEditable(false);
        this.Codigo.setLayoutX(150);
        this.Codigo.setLayoutY(150);

        return Codigo;
    }
    TextField CodigoAtexto() {

        this.CodigoTraducido.setEditable(false);
        this.CodigoTraducido.setLayoutX(350);
        this.CodigoTraducido.setLayoutY(150);

        return CodigoTraducido;
    }

    public Pane getRoot() {
        return mainLayout;
    }

        private static final Map<String, String> abcToMorse = new HashMap<>();

        static {
            abcToMorse.put("A", ".-");
            abcToMorse.put("B", "-...");
            abcToMorse.put("C", "-.-.");
            abcToMorse.put("D", "-..");
            abcToMorse.put("E", ".");
            abcToMorse.put("F", "..-.");
            abcToMorse.put("G", "--.");
            abcToMorse.put("H", "....");
            abcToMorse.put("I", "..");
            abcToMorse.put("J", ".---");
            abcToMorse.put("K", "-.-");
            abcToMorse.put("L", ".-..");
            abcToMorse.put("M", "--");
            abcToMorse.put("N", "-.");
            abcToMorse.put("O", "---");
            abcToMorse.put("P", ".--.");
            abcToMorse.put("Q", "--.-");
            abcToMorse.put("R", ".-.");
            abcToMorse.put("S", "...");
            abcToMorse.put("T", "-");
            abcToMorse.put("U", "..-");
            abcToMorse.put("V", "...-");
            abcToMorse.put("W", ".--");
            abcToMorse.put("X", "-..-");
            abcToMorse.put("Y", "-.--");
            abcToMorse.put("Z", "--..");
            abcToMorse.put("0", "-----");
            abcToMorse.put("1", ".----");
            abcToMorse.put("2", "..---");
            abcToMorse.put("3", "...--");
            abcToMorse.put("4", "....-");
            abcToMorse.put("5", ".....");
            abcToMorse.put("6", "-....");
            abcToMorse.put("7", "--...");
            abcToMorse.put("8", "---..");
            abcToMorse.put("9", "----.");
            abcToMorse.put(" ", " / "); // Espacio entre palabras
        }

        public static String textToMorse(String text) {
            StringBuilder morseCode = new StringBuilder();
            String[] words = text.split(" ");
            for (String word : words) {
                String[] letters = word.split("");
                for (String letter : letters) {
                    morseCode.append(abcToMorse.get(letter.toUpperCase()));
                    morseCode.append(" "); // Agregar espacio entre letras
                }
                morseCode.append(" / "); // Agregar espacio entre palabras
            }
            return morseCode.toString().trim(); // Eliminar el espacio en blanco al final
        }

    private static final Map<String, String> codigomorse = new HashMap<>();

    static {
        codigomorse.put(".-", "A");
        codigomorse.put("-...", "B");
        codigomorse.put("-.-.", "C");
        codigomorse.put("-..", "D");
        codigomorse.put(".", "E");
        codigomorse.put("..-.", "F");
        codigomorse.put("--.", "G");
        codigomorse.put("....", "H");
        codigomorse.put("..", "I");
        codigomorse.put(".---", "J");
        codigomorse.put("-.-", "K");
        codigomorse.put(".-..", "L");
        codigomorse.put("--", "M");
        codigomorse.put("-.", "N");
        codigomorse.put("---", "O");
        codigomorse.put(".--.", "P");
        codigomorse.put("--.-", "Q");
        codigomorse.put(".-.", "R");
        codigomorse.put("...", "S");
        codigomorse.put("-", "T");
        codigomorse.put("..-", "U");
        codigomorse.put("...-", "V");
        codigomorse.put(".--", "W");
        codigomorse.put("-..-", "X");
        codigomorse.put("-.--", "Y");
        codigomorse.put("--..", "Z");
        codigomorse.put("-----", "0");
        codigomorse.put(".----", "1");
        codigomorse.put("..---", "2");
        codigomorse.put("...--", "3");
        codigomorse.put("....-", "4");
        codigomorse.put(".....", "5");
        codigomorse.put("-....", "6");
        codigomorse.put("--...", "7");
        codigomorse.put("---..", "8");
        codigomorse.put("----.", "9");
        codigomorse.put(" ", " "); // Espacio entre palabras
    }

    public static String morseToText(String morseCode) {
        StringBuilder text = new StringBuilder();
        String[] words = morseCode.split(" / ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                text.append(codigomorse.get(letter));
            }
            text.append(" "); // Agregar espacio entre palabras
        }
        return text.toString().trim(); // Eliminar el espacio en blanco al final
    }

    public static void main(String[] args) {
            String text = "HELLO WORLD";
            String morseCode = textToMorse(text);
            System.out.println("Código Morse: " + morseCode);


        }



}



