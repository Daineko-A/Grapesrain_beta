package by.grapesrain.services;

import by.grapesrain.config.TestConfigServices;
import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.RequestAnswer;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Alexandr on 17.07.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfigServices.class)
@Transactional
public class RequestAnswerServiceImplTest {

//    List<RequestAnswer> findByRequest(Request request);
//
//    void save(RequestAnswer requestAnswer, String login);
}
