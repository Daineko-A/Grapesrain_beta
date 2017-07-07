package by.grapesrain.services;

import by.grapesrain.dao.RequestDao;
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

    @Autowired
    public RequestServiceImpl(RequestDao requestDao) {
        this.requestDao = requestDao;
    }


    @Override
    public List<Request> allRequests() {
        return requestDao.findAll();
    }
}
