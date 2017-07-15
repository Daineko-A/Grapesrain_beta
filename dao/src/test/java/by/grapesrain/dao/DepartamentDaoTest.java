package by.grapesrain.dao;

import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by PloSkiY on 03.07.2017.
 */

public class DepartamentDaoTest extends BaseDaoTest {

    @Autowired
    private DepartamentDao departamentDao;

    @Test
    public void saveDepartament(){
        Departament departament = new Departament();
        departament.setName("it");
        departamentDao.save(departament);

        Departament findDepartament = departamentDao.findAll().get(0);
        assertNotNull(findDepartament);
    }

    @Test
    public void findDepartamentById() {
        Departament departament = new Departament();
        departament.setName("it");
        departamentDao.save(departament);

        Departament findDepartament = departamentDao.findById(1);
        Departament departament2 = new Departament();
        departament2.setName("it");

        assertEquals(findDepartament.getName(), departament2.getName());
    }

    @Test
    public void limit(){
        Departament departament = new Departament("it");
        departamentDao.save(departament);

        Departament departament1 = new Departament("man");
        departamentDao.save(departament1);

        Departament departament2 = new Departament("dev1");
        departamentDao.save(departament2);

        Departament departament3 = new Departament("dev2");
        departamentDao.save(departament3);

        Departament departament4 = new Departament("dev3");
        departamentDao.save(departament4);

        Departament departament5 = new Departament("dev4");
        departamentDao.save(departament5);

        List<Departament> departaments = departamentDao.findAllWithPage(1, 3);
        System.out.println("--------------->" + departaments.size());

        assertEquals(departaments.size(), 3);
    }

    @Test
    public void FetchSize(){
        Departament departament = new Departament("it");
        departamentDao.save(departament);

        Departament departament1 = new Departament("man");
        departamentDao.save(departament1);

        Departament departament2 = new Departament("dev1");
        departamentDao.save(departament2);

//        int size = departamentDao.getFetchSize();
        System.out.println("--------------->" + departamentDao.size());

//        assertEquals(size, 3);
    }

    @Test
    public void update() {
        Departament departament = new Departament("it");
        departamentDao.save(departament);

        Departament departament1 = departamentDao.findById(1);
        departament1.setName("qwe");
        departamentDao.update(departament1);

        Departament departament2 = departamentDao.findById(1);
        System.out.println(departament2);

        assertNotNull(departament2);

    }
}
