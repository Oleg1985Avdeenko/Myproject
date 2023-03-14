package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY;
    public static final String PERSISTENCE_UNIT_NAME = "my-project";

    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public void close() {
        ENTITY_MANAGER_FACTORY.close();
    }
}
