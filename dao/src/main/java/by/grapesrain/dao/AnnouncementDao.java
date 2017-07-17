package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDao;
import by.grapesrain.entitys.Announcement;
import by.grapesrain.entitys.Departament;

import java.util.List;

/**
 * Created by PloSkiY on 21.06.2017.
 */
public interface AnnouncementDao extends BaseDao<Announcement> {

    Announcement findByTitle(String title);

    List<Announcement> findAllByDep(Departament departament);
}
