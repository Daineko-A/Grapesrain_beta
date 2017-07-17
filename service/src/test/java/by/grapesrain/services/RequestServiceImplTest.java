package by.grapesrain.services;

import by.grapesrain.config.TestConfigServices;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.Status;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Alexandr on 16.07.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfigServices.class)
@Transactional
public class RequestServiceImplTest {

//    List<Request> allRequests();
//
//    List<Request> allRequestsWithPage(int startR, int limitR);
//
//    Request findById(long id);
//
//    List<Request> findRequestsByDepartament(Departament departament);
//
//    void save(Request request, String login);
//
//    List<Request> allRequestsByDepWithPage(int startR, int limitR, Departament departament);
//
//    List<Request> allRequestsByDepWithPageWithoutClose(int startR, int limitR, Departament departament);
//
//    List<Request> allRequestsByDepWithPageWithClose(int startR, int limitR, Departament departament);
//
//    int quantityRequests(Departament departament, Status status);
//
//    void update(Request request, String executor, String creator);

}
