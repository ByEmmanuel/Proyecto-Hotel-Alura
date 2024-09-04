package Persistence_JPA;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtils {

    private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("HotelAlura");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}