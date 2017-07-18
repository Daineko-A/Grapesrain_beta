package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDaoImpl;
import by.grapesrain.entitys.Role;
import by.grapesrain.entitys.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by PloSkiY on 01.07.2017.
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

    public Role findByRoleName(String roleName) {
        List<Role> roles = getSessionFactory().getCurrentSession().createQuery(
                "select r from Role r where r.role=:role", Role.class)
                .setParameter("role", roleName)
                .getResultList();

        return roles.size() > 0 ? roles.get(0) : null;
    }
}
