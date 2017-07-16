package by.grapesrain.services;

import by.grapesrain.dao.RequestDao;
import by.grapesrain.dao.UserDao;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by PloSkiY on 06.07.2017.
 */
@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    private final RequestDao requestDao;
    private final UserDao userDao;

    @Autowired
    public RequestServiceImpl(RequestDao requestDao, UserDao userDao) {
        this.requestDao = requestDao;
        this.userDao = userDao;
    }

    @Override
    public List<Request> allRequests() {
        return requestDao.findAll();
    }

    @Override
    public List<Request> allRequestsWithPage(int startR, int limitR) {
        return requestDao.findAllWithPage(startR, limitR);
    }

    @Override
    public Request findById(long id) {
        return requestDao.findById(id);
    }

    @Override
    public List<Request> findRequestsByDepartament(Departament departament) {
        return requestDao.findRequestsByDepartament(departament);
    }

    @Override
    public void save(Request request, String login) {
        request.setCreator(userDao.findUserByLogin(login));
        requestDao.save(request);
    }

    @Override
    public List<Request> allRequestsByDepWithPage(int startR, int limitR, Departament departament) {
        return requestDao.allRequestsByDepWithPage(startR, limitR, departament);
    }

    @Override
    public List<Request> allRequestsByDepWithPageWithautClose(int startR, int limitR, Departament departament) {
        return requestDao.allRequestsByDepWithPageWithautClose(startR, limitR, departament);
    }

    @Override
    public int quantityRequests(Departament departament){
        return requestDao.quantityRequests(departament);
    }
}
