package by.grapesrain.dao.common;

import by.grapesrain.entitys.BaseEntity;

import java.util.List;

/**
 * Created by Alexandr on 30.06.2017.
 */
public interface BaseDao<T extends BaseEntity> {

    void save(T entity);

    void update(T entity);

    List<T> findAll();

    T findById(long id);
}
