package DAO;


import Controller.CargarLoginController;
import PantallaPrincipalControles.Controller2;
import Persistence_JPA.JPAUsuarios;
import Persistence_JPA.JPAUtils;
import Persistence_JPA.Reservas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class UsuarioDAO {

    private EntityManager em = JPAUtils.getEntityManager();
/*

    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }
*/




    public void actualizar(JPAUsuarios usuarios) {
        this.em.merge(usuarios);
    }

    public void remover(JPAUsuarios usuario) {
        usuario =this.em.merge(usuario);
        this.em.remove(usuario);
    }

    public JPAUsuarios consultaPorId(Long id) {
        return em.find(JPAUsuarios.class, id);
    }

    /**
     *
     * @param email
     * @param contraseña
     * ESTA FUNCION BUSCA EN LA BASE DE DATOS LAS CREDENCIALES INGRESADAS POR EL USUARIO
     * EN CASO DE QUE COINCIDAN, SE INICIARA SESION
     *
     */
    public List<JPAUsuarios> buscarPorEmailYContraseña(String email, String contraseña) {
        String jpql = "SELECT u FROM JPAUsuarios u WHERE u.email = :email AND u.contraseña = :contraseña";
        TypedQuery<JPAUsuarios> query = em.createQuery(jpql, JPAUsuarios.class);
        query.setParameter("email", email);
        query.setParameter("contraseña", contraseña);
        return query.getResultList();
    }

    public boolean verificarCredenciales(String email, String contraseña) {

        // Buscar usuarios por correo electrónico en la base de datos
        List<JPAUsuarios> usuariosEncontrados = buscarPorEmailYContraseña(email,contraseña);

        if (!usuariosEncontrados.isEmpty()) {
            // Se encontró al menos un usuario con el correo electrónico proporcionado
            // Ahora verifica si la contraseña coincide con alguno de los usuarios encontrados
            for (JPAUsuarios usuario : usuariosEncontrados) {
                if (usuario.getContraseña().equals(contraseña) && usuario.getContraseña().equals(email)) {
                    // La contraseña coincide, las credenciales son válidas
                    return true;
                }
            }
        }

        // No se encontró un usuario con el correo electrónico proporcionado o la contraseña no coincide
        return false;
    }

/*
    //Este metodo solo se utiliza en la clase registro
    public void guardar(JPAUsuarios usuarios) {
        usuarios = new JPAUsuarios(controllerRegistro.getNombre(),controllerRegistro.getEmail(), controllerRegistro.getPassword(), controllerRegistro.getFechaDeNacimiento(), controllerRegistro.getNacionalidad(), controllerRegistro.getTelefono());
        System.out.println("Usuario registrado con exito");

        this.em.persist(usuarios);
    }*/


    /**
     *
     * @FUNCTION
     * ESTA FUNCION CONSULTA A TODAS LAS ENTIDADES DE LA TABLA
     * Y LAS DEVUELVE EN FORMA DE STRING POR LA CONSOLA
     * FALTA POR AÑADIRLA A UN PANE...
     */
    public List<JPAUsuarios> consultarUsuarios() {
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

    public List<Reservas> consultarReservas() {
        String jpql = "SELECT u FROM Reservas u"; // Consulta JPQL para seleccionar todos los registros de Reservas

        TypedQuery<Reservas> query = em.createQuery(jpql, Reservas.class);

        List<Reservas> reservas = query.getResultList();
        for (Reservas reserva : reservas) {
            System.out.println("ID: " + reserva.getIdReserva());
            System.out.println("Fecha Entrada: " + reserva.getFechaEntrada());
            System.out.println("Fecha Salida: " + reserva.getFechaEntrada());
            System.out.println("Forma de Pago: " + reserva.getFormaDePago());
            System.out.println("Nombre Usuario: " + reserva.getUsuario());
            System.out.println("Valor: " + reserva.getValor());
            // Agrega más atributos según tus necesidades
            System.out.println(); // Línea en blanco para separar cada usuario
        }

        return reservas;
    }


    public List<JPAUsuarios> consultaPorNombre(String nombre){
        String jpql =" SELECT P FROM JPAUsuarios AS P WHERE P.nombre=:nombre ";
        return em.createQuery(jpql,JPAUsuarios.class).setParameter("nombre", nombre).getResultList();
    }

    /**
     * este metodo se usa para devolver el nombre de usuario en la interface
     * @param email
     * @return
     */
    public String BuscarPorEmail(String email) {
        email = CargarLoginController.getEmail();
        String jpql = "SELECT u FROM JPAUsuarios u WHERE u.email = :email";
        TypedQuery<JPAUsuarios> query = em.createQuery(jpql, JPAUsuarios.class);
        query.setParameter("email", email);
        try {
            JPAUsuarios usuario = query.getSingleResult();

            return usuario.getNombre();
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            return null;

        }
    }


    /**
     *
     * @param nombre
     * @param email
     * @param password
     * @param fechaDeNacimiento
     * @param nacionalidad
     * @param telefono
     *
     * ESTE METODO O ALGORITMO ES EL QUE HACE LA IMPLEMENTACION DE REGISTROS A
     * LA BASE DE DATOS
     *
     */
    public void RegistrarUsuario(
            String nombre,
            String email,
            String password,
            String fechaDeNacimiento,
            String nacionalidad,
            String telefono
    ){

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

    /**
     *
     * @param FechaEntrada
     * @param FechaSalida
     * @param tipoDePago
     * @param valor
     *
     * ESTE METODO ES EL QUE HACE LOS REGISTROS DE RESERVAS A LA BASE DE DATOS...
     *
     */
    public void guardarReserva(
            String FechaEntrada,
            String FechaSalida,
            String tipoDePago,
            double valor
    ) {
        //Falta por implementar algoritmo que calcula el valor total


        // Ahora puedes usar los valores pasados como parámetros
        Reservas reservaUsuario = new Reservas(
                FechaEntrada,
                FechaSalida,
                valor,
                tipoDePago
        );
        System.out.println("Reserva en calse UsuarioDAO Funcionando");


        String usuarioAutenticado = BuscarPorEmail(CargarLoginController.getEmail()); // Obtén el usuario autenticado de alguna manera

        // Crea una nueva reserva y asigna el usuario autenticado

        reservaUsuario.setUsuario(usuarioAutenticado);

        if (tipoDePago == null){
            //Excepcion por agregar
            throw new RuntimeException("Por favor introduce una forma de pago");
        }

        // Iniciar una transacción
        em.getTransaction().begin();

        // Persistir la entidad en la base de datos

        em.persist(reservaUsuario);

        // Confirmar la transacción
        em.getTransaction().commit();

        // Cerrar el EntityManager y la fábrica de EntityManager
        em.close();
    }

    /**
     *
     * @param email
     * @param contraseña
     * @return
     *
     * Esta Clase Verifica los campos que se estan introduciendo,
     * y verifica si es admin.
     * Posterior mente aparecen las opciones de admin.
     * Esta practica es arriesgada y no se debe de usar
     * ya que estoy poniendo informacion en los campos directos en el codigo
     *
     *
     */
    public boolean esAdmin(String email, String contraseña){
        email = CargarLoginController.getEmail();
        String jpql = "SELECT u FROM JPAUsuarios u WHERE u.email = :email";
        TypedQuery<JPAUsuarios> query = em.createQuery(jpql, JPAUsuarios.class);
        query.setParameter("email", email);
        if (email.equals("Admin1@1") && contraseña.equals("11111") ){
            return true;
        }else {
            return false;
        }

    }
    public void EsTrabajador(String pregunta){
        Controller2 controller = new Controller2();
        controller.esTrabajador();
        em.getTransaction().begin();
        em.persist(pregunta);
        em.getTransaction().commit();
        em.close();
    }
}
