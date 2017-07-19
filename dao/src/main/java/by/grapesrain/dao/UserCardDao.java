package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDao;
import by.grapesrain.entitys.User;
import by.grapesrain.entitys.UserCard;

/**
 * Created by Alexandr on 19.07.2017.
 */
public interface UserCardDao extends BaseDao<UserCard> {

    UserCard findUserCardByUser(User user);
}
