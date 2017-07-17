package by.grapesrain.services;

import by.grapesrain.config.TestConfigServices;
import by.grapesrain.entitys.Departament;
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
public class DepartamentServiceImplTest {

//    List<Departament> allDepartaments();
//
//    Departament findById(long id);
//
//    void update(Departament departament);
//
//    void save(Departament departament);
}
