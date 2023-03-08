package dao.interfaces;

import java.util.List;

public interface DAO <T>{

    T save(T object);

    T update(T object);

    T findById(T object);

    void delete(T object);

    List<T> findAll(T object);
}