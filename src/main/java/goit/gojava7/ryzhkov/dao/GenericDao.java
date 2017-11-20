package goit.gojava7.ryzhkov.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {

    T getById(ID id);

    List<T> getAll();

    ID save(T entity);

    void update(T entity);

    void remove(T entity);

}
