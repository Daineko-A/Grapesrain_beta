package by.grapesrain.services;

import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.RequestAnswer;

import java.util.List;

/**
 * Created by PloSkiY on 11.07.2017.
 */

public interface RequestAnswerService {

    List<RequestAnswer> findByRequest(Request request);

    void save(RequestAnswer requestAnswer, String login);
}
