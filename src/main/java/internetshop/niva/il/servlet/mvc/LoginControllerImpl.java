package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.UserDAO;
import internetshop.niva.il.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by vitanovo on 07.12.2015.
 */
@Component
public class LoginControllerImpl implements LoginController {

    @Autowired
    @Qualifier(value = "UserDAO_HIBERNATE")
    private UserDAO userDAO;


    public String dogetUser(HttpServletRequest request, HttpServletResponse response)
            throws DBException {

            String login = (String) request.getParameter("login");
            String email = (String) request.getParameter("InputEmail1");
            String firstName = (String) request.getParameter("inputName");
            String lastName = (String) request.getParameter("inputSurname");
            String pass = (String) request.getParameter("InputPassword1");

            System.out.println("My login is "+login);
            System.out.println("My email is "+email);

            User user = new User();
            user.setPassword(pass);
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);

            System.out.println(user.getPassword());

        if (request.getParameter("login") != null) {
            userDAO.create(user);
        }
            return  user.toString();
        }


    @Transactional
    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws DBException, SQLException, ServletException, Exception {

        return new MVCModel(dogetUser(request, response), "/Login.jsp");

    }
}