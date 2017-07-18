package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDao;
import by.grapesrain.entitys.Role;

/**
 * Created by PloSkiY on 01.07.2017.
 */
public interface RoleDao extends BaseDao<Role> {

    Role findByRoleName(String roleName);
}
