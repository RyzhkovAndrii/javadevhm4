package goit.gojava7.ryzhkov.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class HibernateDao<T, ID extends Serializable> implements GenericDao<T, ID> {

    private Class<T> type;
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public HibernateDao() {
        sessionFactory = StorageUtils.getSessionFactory();
    }

    private void openSession() {
        session = sessionFactory.openSession();
    }

    private void closeSession() {
        session.close();
    }

    private void openSessionWithTransaction() {
        openSession();
        transaction = session.beginTransaction();
    }

    private void closeSessionWithTransaction() {
        transaction.commit();
        closeSession();
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

    public T getById(ID id) {
        T entity;
        openSession();
        entity = session.get(type, id);
        closeSession();
        return entity;
    }

    public List<T> getAll() {
        List<T> resultList;
        openSession();
        resultList = session.createQuery("from " + type.getSimpleName(), type).list();
        closeSession();
        return resultList;
    }

    public ID save(T entity) {
        openSessionWithTransaction();
        ID id = (ID) session.save(entity);
        closeSessionWithTransaction();
        return id;
    }

    public void update(T entity) {
        openSessionWithTransaction();
        session.update(entity);
        closeSessionWithTransaction();
    }

    public void remove(T entity) {
        openSessionWithTransaction();
        session.remove(entity);
        closeSessionWithTransaction();
    }

}
