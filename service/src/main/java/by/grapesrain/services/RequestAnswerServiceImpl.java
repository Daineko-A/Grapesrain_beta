package by.grapesrain.services;

import by.grapesrain.dao.RequestAnswerDao;
import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.RequestAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by PloSkiY on 11.07.2017.
 */
@Service
@Transactional
public class RequestAnswerServiceImpl implements RequestAnswerService {

    private final RequestAnswerDao requestAnswerDao;

    @Autowired
    public RequestAnswerServiceImpl(RequestAnswerDao requestAnswerDao) {
        this.requestAnswerDao = requestAnswerDao;
    }

    @Override
    public List<RequestAnswer> findByReques(Request request) {
        return requestAnswerDao.findByRequest(request);
    }
}
