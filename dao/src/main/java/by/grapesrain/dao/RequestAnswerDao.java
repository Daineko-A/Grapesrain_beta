package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDao;
import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.RequestAnswer;

import java.util.List;

/**
 * Created by Alexandr on 11.07.2017.
 */
public interface RequestAnswerDao extends BaseDao<RequestAnswer> {

    public List<RequestAnswer> findRequestAnswersByRequest(Request request);
}
