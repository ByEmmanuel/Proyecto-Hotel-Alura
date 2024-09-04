package DAO;

import Persistence_JPA.JPAUsuarios;
import Persistence_JPA.JPAUtils;
import Persistence_JPA.Reservas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class DataBasePruebasDAO {
    /**
     * ESTA CLASE ES UNA DE PRUEBA,
     * AQUI SE INTRODUCEN LOS VALORES Y SE PRUEBAN CON EL METODO MAIN
     */

    public static void main(String[] args) {


        //consultarUsuarios();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.consultarReservas();

        //consultarReservas();



    }
    public static void EliminarUsuario(){
        EntityManager em = JPAUtils.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        // Iniciar una transacción
        em.getTransaction().begin();

        // Obtener la entidad que deseas eliminar (puedes usar find() o cargar la entidad de alguna otra manera)
        //JPAUsuarios usuario = usuarioDAO.consultaPorId(11l);

        JPAUsuarios usuario = usuarioDAO.consultaPorId(11l);

        if (usuario != null) {
            // Eliminar la entidad
            em.remove(usuario);
            System.out.println("usuario eliminado");
        } else {
            // La entidad no existe o ya ha sido eliminada
            System.out.println("El usuario no existe o ya ha sido eliminado.");
        }

        // Confirmar la transacción
        em.getTransaction().commit();

        // Cerrar el EntityManager
        em.close();
    }


    public void RegistrarUsuario(
                String nombre,
                String email,
                String password,
                String fechaDeNacimiento,
                String nacionalidad,
                String telefono
    ){
            EntityManager em = JPAUtils.getEntityManager();
            // Ahora puedes usar los valores pasados como parámetros
            JPAUsuarios usuario = new JPAUsuarios(
                    nombre,
                    email,
                    password,
                    fechaDeNacimiento,
                    nacionalidad,
                    telefono
            );

        if (email == null){
            //Excepcion por agregar
            throw new RuntimeException();
        }

        // Iniciar una transacción
        em.getTransaction().begin();

        // Persistir la entidad en la base de datos

        em.persist(usuario);

        // Confirmar la transacción
        em.getTransaction().commit();

        // Cerrar el EntityManager y la fábrica de EntityManager
        em.close();

    }

    public static void BuscarLogin() {
        // Crear una instancia de EntityManager
        EntityManager em = JPAUtils.getEntityManager();

// Crear una instancia de UsuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();

// Supongamos que tienes una variable 'email' y 'contraseña' que representan las credenciales ingresadas por el usuario
        String email = "a2wes";
        String contraseña = "as";

/*
// Buscar usuarios por correo electrónico y contraseña
        List<JPAUsuarios> usuariosEncontrados = usuarioDAO.buscarPorEmailYContraseña(email, contraseña);

        if (!usuariosEncontrados.isEmpty()) {
            // Credenciales válidas: El usuario existe en la base de datos y las credenciales coinciden.
            // Realiza las acciones necesarias aquí, como iniciar sesión o redirigir al usuario.
            System.out.println("Usuario correcto");
        } else {
            // Credenciales no válidas: No se encontraron usuarios con las credenciales proporcionadas.
            // Puedes mostrar un mensaje de error al usuario.
            System.out.println("Usuario INcorrecto");
        }
*/

// Cerrar el EntityManager
        em.close();
    }
    public List<JPAUsuarios> buscarPorEmailYContraseña(String email, String contraseña) {
        EntityManager em = JPAUtils.getEntityManager();
        String jpql = "SELECT u FROM JPAUsuarios u WHERE u.email = :email AND u.contraseña = :contraseña";
        TypedQuery<JPAUsuarios> query = em.createQuery(jpql, JPAUsuarios.class);
        query.setParameter("email", email);
        query.setParameter("contraseña", contraseña);
        return query.getResultList();
    }
    public JPAUsuarios consultaPorId(Long id) {
        EntityManager em = JPAUtils.getEntityManager();
        return em.find(JPAUsuarios.class, id);
    }

    /**
     *
     * @missing
     * falta por implementar esto
     */
    public static List<JPAUsuarios> consultarUsuarios() {

        EntityManager em = JPAUtils.getEntityManager();

        String jpql = "SELECT u FROM JPAUsuarios u"; // Consulta JPQL para seleccionar todos los registros de JPAUsuarios

        TypedQuery<JPAUsuarios> query = em.createQuery(jpql, JPAUsuarios.class);

        List<JPAUsuarios> usuarios = query.getResultList();
        for (JPAUsuarios usuario : usuarios) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Contraseña: " + usuario.getContraseña());
            // Agrega más atributos según tus necesidades
            System.out.println(); // Línea en blanco para separar cada usuario
        }

        return usuarios;
    }
    public static List<Reservas> consultarReservas() {

        EntityManager em = JPAUtils.getEntityManager();

        String jpql = "SELECT u FROM Reservas u"; // Consulta JPQL para seleccionar todos los registros de JPAUsuarios

        TypedQuery<Reservas> query = em.createQuery(jpql, Reservas.class);

        List<Reservas> reservas = query.getResultList();
        for (Reservas reserva : reservas) {
            System.out.println("ID: " + reserva.getIdReserva());
            System.out.println("Fecha entrada: " + reserva.getFechaEntrada());
            System.out.println("Fecha Salida: " + reserva.getFechaSalida());
            System.out.println("Forma de pago: " + reserva.getFormaDePago());
            System.out.println("Usuario: " + reserva.getUsuario() );
            System.out.println("Valor: " + reserva.getValor());
            // Agrega más atributos según tus necesidades
            System.out.println(); // Línea en blanco para separar cada usuario
        }

        return reservas;
    }
}

