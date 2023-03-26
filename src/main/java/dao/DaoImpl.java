package dao;

import utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DaoImpl<T> implements DAO<T> {

    public static final String FROM = "from ";

//    private final Class<T> objectClass;
//
//
//    public DaoImpl(Class<T> objectClass) {
//        this.objectClass = objectClass;
//    }

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

//    @Override
//    public Integer getNumberOfRows() {
//        EntityManager em = HibernateUtil.getEntityManager();
//        em.getTransaction().begin();
//
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<T> criteria = builder.createQuery(objectClass);
//        Root<T> root = criteria.from(objectClass);
//
//        Integer size = em.createQuery(criteria).getResultList().size();
//
//        em.getTransaction().commit();
//        em.close();
//        return size;
//    }
}
