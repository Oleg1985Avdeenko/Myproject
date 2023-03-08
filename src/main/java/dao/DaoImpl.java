package dao;

import dao.interfaces.DAO;
import utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoImpl<T> implements DAO<T> {

    public static final String FROM = "from ";

    @Override
    public T save(T object) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        em.close();
        return object;
    }

    @Override
    public T update(T object) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        em.close();
        return object;
    }

    @Override
    public T findById(T object) {
        EntityManager em = HibernateUtil.getEntityManager();
        T object1 = (T) em.find(object.getClass(), object);
        em.close();
        return object1;
    }

    @Override
    public void delete(T object) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(object) ? object : em.merge(object));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<T> findAll(T object) {

        EntityManager em = HibernateUtil.getEntityManager();
        String sql = FROM + object.getClass().getSimpleName();
        List<T> objects = em.createQuery(sql).getResultList();
        em.close();
        return objects;
    }
}
