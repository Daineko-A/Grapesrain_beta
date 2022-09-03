package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDaoImpl;
import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.RequestAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alexandr on 11.07.2017.
 */
@Repository
public class RequestAnswerDaoImpl extends BaseDaoImpl<RequestAnswer> implements RequestAnswerDao {

    private final RequestDao requestDao;

    @Autowired
    public RequestAnswerDaoImpl(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    @Override
    public List<RequestAnswer> findByRequest(Request request) {
        List<RequestAnswer> requestAnswers = getSessionFactory().getCurrentSession().createQuery(
                        "select a from RequestAnswer a where a.request=:request", RequestAnswer.class)
                .setParameter("request", request)
                .getResultList();

        return requestAnswers.size() > 0 ? requestAnswers : null;
    }
}
