package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDaoImpl;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by PloSkiY on 01.07.2017.
 */
@Repository
public class DepartamentDaoImpl extends BaseDaoImpl<Departament> implements DepartamentDao {

    @Override
    public Departament updateDep(Departament departament) {

        return null;
    }

//    @Override
//    public Departament findById(long id) {
//        List<Departament> departaments = getSessionFactory().getCurrentSession().createQuery(
//                "select d from Departament d where d.id=:id", Departament.class)
//                .setParameter("id", id)
////                .setHint("org.hibernate.cacheable", true)
//                .getResultList();
//
//        return departaments.size() > 0 ? departaments.get(0) : null;
//    }
}
