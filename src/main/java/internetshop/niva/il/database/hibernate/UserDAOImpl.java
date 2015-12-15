package internetshop.niva.il.database.hibernate;

import internetshop.niva.il.database.UserDAO;
import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.jdbc.DAOImplement;
import internetshop.niva.il.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by vitanovo on 07.12.2015.
 */
@Component("UserDAO_HIBERNATE")
@Transactional
public class UserDAOImpl extends DAOImplement implements UserDAO {


    @Autowired
    private SessionFactory sessionFactory;


    public void create(User user) throws DBException {
        sessionFactory.getCurrentSession().save(user);
    }


    public void delete(User user) throws DBException {
        sessionFactory.getCurrentSession().delete(user);
    }


    public void update(User user) throws DBException {
        sessionFactory.getCurrentSession().update(user);
    }


    public User getById(Long id) throws DBException {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }


    @SuppressWarnings("unchecked")
    public List<User> getAll() throws DBException {
        return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }


    public User getUserByLogin(String login) throws DBException {
        List result = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.or(
                Restrictions.like("login", login),
                Restrictions.eq("email", login)))
                .list();

        return result.size() == 1 ? (User)result.get(0) : null;
    }
}