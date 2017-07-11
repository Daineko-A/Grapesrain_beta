package by.grapesrain.services;

import by.grapesrain.dao.RequestAnswerDao;
import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.RequestAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PloSkiY on 11.07.2017.
 */

public interface RequestAnswerService {

    List<RequestAnswer> findByReques(Request request);
}
