package by.grapesrain.services;

import by.grapesrain.dao.RequestAnswerDao;
import by.grapesrain.dao.RequestDao;
import by.grapesrain.dao.UserDao;
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
    private final RequestDao requestDao;
    private final UserDao userDao;

    @Autowired
    public RequestAnswerServiceImpl(RequestAnswerDao requestAnswerDao, RequestDao requestDao, UserDao userDao) {
        this.requestAnswerDao = requestAnswerDao;
        this.requestDao = requestDao;
        this.userDao = userDao;
    }

    @Override
    public List<RequestAnswer> findByRequest(Request request) {
        return requestAnswerDao.findByRequest(request);
    }

    @Override
    public void save(RequestAnswer requestAnswer, String login) {
        requestAnswer.setRespondent(userDao.findUserByLogin(login));
        requestAnswerDao.save(requestAnswer);
    }


}
