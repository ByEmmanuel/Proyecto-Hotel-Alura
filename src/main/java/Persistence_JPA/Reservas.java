package Persistence_JPA;


import jakarta.persistence.*;

@Entity
@Table(name = "Reservas")
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdReserva;

    private String FechaEntrada;

    private String FechaSalida;
    private double Valor;
    private String FormaDePago;
    private String Usuario;



    @ManyToOne
    @JoinColumn(name = "usuario_id") // Nombre de la columna que hace referencia al usuario en la tabla de Reservas
    private JPAUsuarios usuario;



    public Reservas() {}

    public Reservas(String fechaEntrada, String fechaSalida, double valor, String formaDePago) {
        FechaEntrada = fechaEntrada;
        FechaSalida = fechaSalida;
        Valor = valor;
        FormaDePago = formaDePago;

    }

    public Long getIdReserva() {
        return IdReserva;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        this.Usuario = usuario;
    }

    public String getFechaEntrada() {
        return FechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        FechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        FechaSalida = fechaSalida;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        Valor = valor;
    }

    public String getFormaDePago() {
        return FormaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        FormaDePago = formaDePago;
    }


}
