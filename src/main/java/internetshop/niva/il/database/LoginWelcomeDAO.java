package internetshop.niva.il.database;

import internetshop.niva.il.domain.LoginWelcome;

/**
 * Created by ilugovecs on 2016.01.18..
 */
public interface LoginWelcomeDAO {

    LoginWelcome getByLogin(String login);

    LoginWelcome getUserLogin(String login);


}
