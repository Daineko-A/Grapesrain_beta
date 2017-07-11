package by.grapesrain.dao;

import by.grapesrain.entitys.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alexandr on 11.07.2017.
 */
public class RequestAnswerDaoTest extends BaseDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DepartamentDao departamentDao;

    @Autowired
    private RequestDao requestDao;

    @Autowired
    private RequestAnswerDao requestAnswerDao;

    @Test
    public void requestAnswersByRequest() {
        Departament departament = new Departament("dep");
        User user = new User("First", "Last", "login", "pass", "e@mail.by", departament);
        User user2 = new User("First2", "Last2", "login2", "pass2", "e2@mail.by", departament);
        Request request = new Request("title", "body", user, Status.OPEN, departament, Priority.MEDIUM);
        RequestAnswer requestAnswer = new RequestAnswer(request, user2, "bodyRA");

        departamentDao.save(departament);
        userDao.save(user);
        userDao.save(user2);
        requestDao.save(request);
        requestAnswerDao.save(requestAnswer);

        RequestAnswer findRequestAnswer = requestAnswerDao.findByRequest(request).get(0);
        User findRAUser = findRequestAnswer.getRespondent();

        System.out.println(findRequestAnswer);

        assertEquals(findRAUser, user2);
        assertEquals(findRequestAnswer, requestAnswer);
    }
}
