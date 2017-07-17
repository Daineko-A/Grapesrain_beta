package by.grapesrain.dao;

import by.grapesrain.entitys.Announcement;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by PloSkiY on 03.07.2017.
 */
public class AnnouncementDaoTest extends BaseDaoTest {

    @Autowired
    private AnnouncementDao announcementDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DepartamentDao departamentDao;

    @Test
    public void findByTitleAnnouncement() {
        User user = new User("Anton", "Antonov", "A1", "123", "asd@ad.asd");
        userDao.save(user);
        Departament departament = new Departament("testDep");
        departamentDao.save(departament);
        LocalDateTime date = LocalDateTime.now();
        Announcement announcement = new Announcement("first", "body", user, date, date, departament);

        announcementDao.save(announcement);
        Announcement findAnnouncement = announcementDao.findByTitle("first");

        assertEquals(findAnnouncement, announcement);
    }

    @Test
    public void findAllByDep() {
        User user = new User("Anton", "Antonov", "A1", "123", "asd@ad.asd");
        userDao.save(user);
        Departament departament = new Departament("testDep");
        departamentDao.save(departament);
        LocalDateTime date = LocalDateTime.now();
        Announcement announcement = new Announcement("first", "body", user, date, date, departament);

        announcementDao.save(announcement);
        Announcement findAnnouncement = announcementDao.findAllByDep(departament).get(0);

        assertEquals(findAnnouncement, announcement);
    }
}
