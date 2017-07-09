package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDao;
import by.grapesrain.dao.common.BaseDaoImpl;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Request;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by PloSkiY on 01.07.2017.
 */
@Repository
public class RequestDaoImpl extends BaseDaoImpl<Request> implements RequestDao {

    @Override
    public List<Request> findRequestsByDepartament(Departament departament) {
        List<Request> requests = getSessionFactory().getCurrentSession().createQuery(
                "select r from Request r where r.departament=:departament", Request.class)
                .setParameter("departament", departament)
                .getResultList();

        return requests.size() > 0 ? requests : null;
    }
}
