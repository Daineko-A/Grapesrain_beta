package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDaoImpl;
import by.grapesrain.entitys.User;
import by.grapesrain.entitys.UserCard;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alexandr on 19.07.2017.
 */
@Repository
public class UserCardDaoImpl extends BaseDaoImpl<UserCard> implements UserCardDao {

    @Override
    public UserCard findUserCardByUser(User user) {
        List<UserCard> userCards = getSessionFactory().getCurrentSession().createQuery(
                "select uc from UserCard uc where uc.user=:user", UserCard.class)
                .setParameter("user", user)
                .getResultList();

        return userCards.size() > 0 ? userCards.get(0) : null;
    }
}
