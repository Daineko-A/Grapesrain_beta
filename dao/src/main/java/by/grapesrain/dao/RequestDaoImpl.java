package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDaoImpl;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.Status;
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

    @Override
    public List<Request> allRequestsByDepWithPage(int startR, int limitR, Departament departament) {
        List<Request> requests = getSessionFactory().getCurrentSession().createQuery(
                        "select r from Request r where r.departament=:departament", Request.class)
                .setParameter("departament", departament)
                .setFirstResult(startR)
                .setMaxResults(limitR)
                .getResultList();

        return requests.size() > 0 ? requests : null;
    }

    @Override
    public List<Request> allRequestsByDepWithPageWithoutClose(int startR, int limitR, Departament departament) {
        List<Request> requests = getSessionFactory().getCurrentSession().createQuery(
                        "select r from Request r where r.status!=:close and r.departament=:departament ", Request.class)
                .setParameter("departament", departament)
                .setParameter("close", Status.CLOSED)
                .setFirstResult(startR)
                .setMaxResults(limitR)
                .getResultList();

        return requests.size() > 0 ? requests : null;
    }

    @Override
    public List<Request> allRequestsByDepWithPageWithClose(int startR, int limitR, Departament departament) {
        List<Request> requests = getSessionFactory().getCurrentSession().createQuery(
                        "select r from Request r where r.status=:close and r.departament=:departament ", Request.class)
                .setParameter("departament", departament)
                .setParameter("close", Status.CLOSED)
                .setFirstResult(startR)
                .setMaxResults(limitR)
                .getResultList();

        return requests.size() > 0 ? requests : null;
    }

    @Override
    public int quantityRequests(Departament departament, Status status) {
        if (status.equals(Status.CLOSED)) {
            return getSessionFactory().getCurrentSession().createQuery(
                            "select r from Request r where r.status=:close and r.departament=:departament", Request.class)
                    .setParameter("departament", departament)
                    .setParameter("close", Status.CLOSED)
                    .getResultList().size();
        }

        return getSessionFactory().getCurrentSession().createQuery(
                        "select r from Request r where r.status!=:close and r.departament=:departament", Request.class)
                .setParameter("departament", departament)
                .setParameter("close", Status.CLOSED)
                .getResultList().size();

    }
}
