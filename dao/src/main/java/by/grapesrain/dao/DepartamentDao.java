package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDao;
import by.grapesrain.entitys.Departament;

/**
 * Created by PloSkiY on 01.07.2017.
 */
public interface DepartamentDao extends BaseDao<Departament> {

    Departament updateDep(Departament departament);
}
