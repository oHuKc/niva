package internetshop.niva.il.database.hibernate;

import internetshop.niva.il.database.LoginWelcomeDAO;
import internetshop.niva.il.database.jdbc.DAOImplement;
import internetshop.niva.il.domain.LoginWelcome;
import internetshop.niva.il.servlet.mvc.LoginWelcomeController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by ilugovecs on 2016.01.18..
 */
@Component("LoginWelcomeDAO_Hibernate")
@Transactional
public class LoginWelcomeDAOImpl extends DAOImplement implements LoginWelcomeDAO {

    @Autowired
    private SessionFactory sessionFactory;



    public LoginWelcome getByLogin(String login) {
        return (LoginWelcome) sessionFactory.getCurrentSession().get(LoginWelcome.class, login);
    }


    public LoginWelcome getUserLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        return (LoginWelcome)  session.get(LoginWelcome.class, login);
    }
}
