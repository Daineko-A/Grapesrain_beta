package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDaoImpl;
import by.grapesrain.entitys.Announcement;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by PloSkiY on 01.07.2017.
 */
@Repository
public class AnnouncementDaoImpl extends BaseDaoImpl<Announcement> implements AnnouncementDao {

    @Override
    public Announcement findByTitle(String title) {
        List<Announcement> announcementsList = getSessionFactory().getCurrentSession().createQuery(
                "select a from Announcement a where a.title=:title", Announcement.class)
                .setParameter("title", title)
                .getResultList();

        return announcementsList.size() > 0 ? announcementsList.get(0) : null;
    }
}
