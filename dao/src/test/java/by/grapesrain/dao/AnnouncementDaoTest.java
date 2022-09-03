package by.grapesrain.dao;

import by.grapesrain.entitys.Announcement;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void save() {
        User user = new User("Anton", "Antonov", "A1", "123", "asd@ad.asd");
        userDao.save(user);
        Departament departament = new Departament("testDep");
        departamentDao.save(departament);
        LocalDateTime date = LocalDateTime.now();
        Announcement announcement = new Announcement("first", "body", user, date, date, departament);
        announcement.setBegin(LocalDateTime.of(2017, 11, 23, 11, 15));
        announcement.setEnd(LocalDateTime.of(2017, 11, 24, 11, 15));
        announcementDao.save(announcement);

        Announcement findAnnouncement = announcementDao.findByTitle("first");
        System.out.println(findAnnouncement.getBegin());
        System.out.println(findAnnouncement.getEnd());

        assertEquals(findAnnouncement, announcement);
    }

    @Test
    public void findAllActualByDep() {
        User user = new User("Anton", "Antonov", "A1", "123", "asd@ad.asd");
        userDao.save(user);
        Departament departament = new Departament("testDep");
        departamentDao.save(departament);
        LocalDateTime date = LocalDateTime.now();
        Announcement announcement = new Announcement("Past", "body", user, date, date, departament);
        announcement.setBegin(LocalDateTime.now().minusMinutes(10));
        announcement.setEnd(LocalDateTime.now().minusMinutes(5));
        announcementDao.save(announcement);

        Announcement announcement2 = new Announcement("Future", "body", user, date, date, departament);
        announcement.setBegin(LocalDateTime.now());
        announcement.setEnd(LocalDateTime.now().plusMinutes(30));
        announcementDao.save(announcement2);

        int size = announcementDao.findAllActualByDep(departament).size();
        assertEquals(size, 1);
    }

    @Test
    public void findAllPastByDep() {
        User user = new User("Anton", "Antonov", "A1", "123", "asd@ad.asd");
        userDao.save(user);
        Departament departament = new Departament("testDep");
        departamentDao.save(departament);
        LocalDateTime date = LocalDateTime.now();
        Announcement announcement = new Announcement("Future", "body", user, date, date, departament);
        announcement.setBegin(LocalDateTime.now().plusMinutes(10));
        announcement.setEnd(LocalDateTime.now().plusMinutes(15));
        announcementDao.save(announcement);

        Announcement announcement2 = new Announcement("Past", "body", user, date, date, departament);
        announcement.setBegin(LocalDateTime.now().minusMinutes(20));
        announcement.setEnd(LocalDateTime.now().minusMinutes(15));
        announcementDao.save(announcement2);

        int size = announcementDao.findAllPastByDep(departament).size();
        assertEquals(size, 1);
    }

}
