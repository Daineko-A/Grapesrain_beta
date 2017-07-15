package by.grapesrain.services;

import by.grapesrain.dao.AnnouncementDao;
import by.grapesrain.dao.UserDao;
import by.grapesrain.entitys.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by PloSkiY on 09.07.2017.
 */
@Service
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementDao announcementDao;
    private final UserDao userDao;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementDao announcementDao, UserDao userDao) {
        this.announcementDao = announcementDao;
        this.userDao = userDao;
    }

    @Override
    public List<Announcement> allAnnouncements() {
        return announcementDao.findAll();
    }

    @Override
    public Announcement findById(long id) {
        return announcementDao.findById(id);
    }

    @Override
    public void save(Announcement announcement, String login) {
        announcement.setCreator(userDao.findUserByLogin(login));
        announcementDao.save(announcement);
    }
}
