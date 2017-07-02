package by.grapesrain.services;

import by.grapesrain.dao.UserRoleDao;
import by.grapesrain.entitys.UserRole;
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

    private final UserRoleDao userRoleDao;

    @Autowired
    public UserRoleServiceImpl(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Override
    public List<UserRole> allUserRoles() {
        return null;
    }
}
