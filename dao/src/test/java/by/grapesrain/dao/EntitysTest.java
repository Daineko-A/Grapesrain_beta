package by.grapesrain.dao;


import by.grapesrain.dao.UserDao;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import by.grapesrain.entitys.UserRole;
import by.grapesrain.util.EmployeeTestDataImporter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

/**
 * Created by PloSkiY on 20.06.2017.
 */
public class EntitysTest {

    private SessionFactory sessionFactory;

    @Before
    public void initDB() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        EmployeeTestDataImporter.getInstance().importTestData(sessionFactory);
    }

    @Test
    public void testFindAllRole() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<UserRole> results = UserDao.getInstance().findAllRole(session);
        List<String> roles
                = results.stream().map(UserRole::getRole).collect(toList());
        assertThat(results, hasSize(3));
        assertThat(roles, containsInAnyOrder("Admin", "User", "Client"));

        session.getTransaction().commit();
        session.close();
    }


    @Test
    public void testFindAllUser() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<User> results = UserDao.getInstance().findAllUsers(session);
        List<String> lastNames
                = results.stream().map(User::getLastName).collect(toList());
        assertThat(results, hasSize(3));
        assertThat(lastNames, containsInAnyOrder("LAlex", "LOlga", "LDima"));

        session.getTransaction().commit();
        session.close();
    }


    @Test
    public void testFindAllDepartament() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Departament> results = UserDao.getInstance().findAllDepartaments(session);
        List<String> departamentNames
                = results.stream().map(Departament::getName).collect(toList());
        assertThat(results, hasSize(3));
        assertThat(departamentNames, containsInAnyOrder("It", "Buhg", "Managers"));

        session.getTransaction().commit();
        session.close();
    }


    @After
    public void finish() {
        sessionFactory.close();
    }

}
