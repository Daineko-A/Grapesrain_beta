package by.grapesrain.util;

import by.grapesrain.config.TestConfigDB;
import by.grapesrain.dao.BaseDaoTest;
import by.grapesrain.dao.DepartamentDao;
import by.grapesrain.dao.UserDao;
import by.grapesrain.dao.UserRoleDao;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import by.grapesrain.entitys.UserRole;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by PloSkiY on 22.06.2017.
 */
public class EmployeeTestDataImporter{

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private DepartamentDao departamentDao;

    public void importTestData() {
        Departament departament = new Departament();
        departament.setName("ИТ");
        departamentDao.save(departament);

        UserRole userRole = new UserRole();
        userRole.setRole("Админ");
        userRoleDao.save(userRole);

//        User user = new User();
//        user.setFirstName("asd");
//        user.setLastName("dsa");
//        user.setDepartament(departamentDao.findAll().get(0));
//        user.setEmail("asd@Asd.asd");
//        user.setPhoneNumber(375291234567L);
//        user.setPassword("123456");
//        user.setUserRole(userRoleDao.findAll().get(0));
//
//        userDao.save(user);



//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Departament it = new Departament("It");
//        Departament buhg = new Departament("Buhg");
//        Departament managers = new Departament ("Managers");
//
//        UserRole admin = new UserRole("Admin");
//        UserRole user = new UserRole("User");
//        UserRole client = new UserRole("Client");
//
//        User alex = new User("Alex", "LAlex", "123", 123456789, "asdf@adsf.bt");
//        User olga = new User("Olga", "LOlga", "321", 122435, "asdf@saf.sa");
//        User dima = new User("Dima", "LDima", "4321", 213432532, "sdf@adsf.com");
//
//
//        session.save(it);
//        session.save(buhg);
//        session.save(managers);
//
//        session.save(admin);
//        session.save(user);
//        session.save(client);
//
//        UserDaoImpl.getInstance().saveEntity(session, alex);
//        UserDaoImpl.getInstance().saveEntity(session, olga);
//        UserDaoImpl.getInstance().saveEntity(session, dima);
//
//        session.getTransaction().commit();
//        session.close();
    }
}
