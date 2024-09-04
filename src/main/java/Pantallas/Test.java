package Pantallas;

import DAO.UsuarioDAO;
import Persistence_JPA.JPAUsuarios;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String lista = usuarioDAO.consultarUsuarios().toString();

        System.out.println(lista);


    }
}
