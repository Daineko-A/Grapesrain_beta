package by.grapesrain.services;

import by.grapesrain.dao.RoleDao;
import by.grapesrain.entitys.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alexandr on 02.07.2017.
 */
@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    private final RoleDao roleDao;

    @Autowired
    public UserRoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> allUserRoles() {
        return roleDao.findAll();
    }
}
