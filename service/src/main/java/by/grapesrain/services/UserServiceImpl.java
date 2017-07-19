package by.grapesrain.services;

import by.grapesrain.dao.UserCardDao;
import by.grapesrain.dao.UserDao;
import by.grapesrain.dao.RoleDao;
import by.grapesrain.entitys.Role;
import by.grapesrain.entitys.User;
import by.grapesrain.entitys.UserCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by PloSkiY on 01.07.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {


    private final UserDao userDao;
    private final RoleDao roleDao;
    private final UserCardDao userCardDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, UserCardDao userCardDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.userCardDao = userCardDao;
    }


    @Override
    public User findByLogin(String login) {
        User securityUser = new User();
        securityUser.setFirstName(userDao.findUserByLogin(login).getFirstName());
        securityUser.setLastName(userDao.findUserByLogin(login).getLastName());
        securityUser.setDepartament(userDao.findUserByLogin(login).getDepartament());
        securityUser.setEmail(userDao.findUserByLogin(login).getEmail());
        securityUser.setLogin(userDao.findUserByLogin(login).getLogin());
        securityUser.setVersion(userDao.findUserByLogin(login).getVersion());
        securityUser.setId(userDao.findUserByLogin(login).getId());
        securityUser.setUserCard(getUserCardByUser(userDao.findUserByLogin(login)));
        return securityUser;
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void save(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findByRoleName("User"));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public List<User> allUsers() {
        return userDao.findAll();
    }

    @Override
    public Long getDepartamentBylogin(String login) {
        return userDao.findUserByLogin(login).getDepartament().getId();
    }

    @Override
    public UserCard getUserCardByUser(User user) {
        return userCardDao.findUserCardByUser(user);
    }

    private Set<GrantedAuthority> getUserAuthorities(User user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return grantedAuthorities;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.findUserByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getLogin(), user.getPassword(), getUserAuthorities(user));
    }
}
