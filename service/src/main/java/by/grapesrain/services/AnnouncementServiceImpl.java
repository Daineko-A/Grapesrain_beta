package by.grapesrain.services;

import by.grapesrain.dao.AnnouncementDao;
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

    @Autowired
    public AnnouncementServiceImpl(AnnouncementDao announcementDao) {
        this.announcementDao = announcementDao;
    }

    @Override
    public List<Announcement> allAnnouncements() {
        return announcementDao.findAll();
    }

    @Override
    public Announcement findById(long id) {
        return announcementDao.findById(id);
    }
}
