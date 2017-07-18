package by.grapesrain.dao.common;

import by.grapesrain.entitys.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.util.List;

/**
 * Created by Alexandr on 30.06.2017.
 */

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;
    private final Class<T> modelClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        this.modelClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void save(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "from " + modelClass.getSimpleName(), modelClass)
                .getResultList();
    }

    @Override
    public List<T> findAllWithPage(int startR, int limitR) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "from " + modelClass.getSimpleName(), modelClass)
                .setFirstResult(startR)
                .setMaxResults(limitR)
                .getResultList();
    }

    @Override
    public T findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "select t from "+ modelClass.getSimpleName() + " t where t.id=:id", modelClass)
                .setParameter("id", id)
                .getResultList().get(0);
    }

    //TODO: переделать этот кастыль.
    @Override
    public int size() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "from " + modelClass.getSimpleName(), modelClass)
                .getResultList().size();
    }
}
