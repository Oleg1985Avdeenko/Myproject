package service;

import java.util.List;

public interface Service<T> {

    T save(T object);

    void update(T object);

    void delete(T object);

    T findById(T object);

    List<T> findAll();
}
