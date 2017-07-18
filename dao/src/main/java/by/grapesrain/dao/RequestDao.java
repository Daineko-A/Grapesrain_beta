package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDao;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.Status;

import java.util.List;

/**
 * Created by PloSkiY on 21.06.2017.
 */
public interface RequestDao extends BaseDao<Request> {

    List<Request> findRequestsByDepartament(Departament departament);

    List<Request> allRequestsByDepWithPage(int startR, int limitR, Departament departament);

    List<Request> allRequestsByDepWithPageWithoutClose(int startR, int limitR, Departament departament);

    List<Request> allRequestsByDepWithPageWithClose(int startR, int limitR, Departament departament);

    public int quantityRequests(Departament departament, Status status);
}
