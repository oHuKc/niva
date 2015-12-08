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

    @Transactional
    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws DBException, SQLException, ServletException, IOException {


        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String firstName = request.getParameter("inputName");
        String lastName = request.getParameter("inputSurname");
        String pass = request.getParameter("InputPassword1");

        System.out.println("My login is "+login);
        System.out.println("My email is "+email);

        User user = new User();
        user.setPassword(pass);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        System.out.println(user.getPassword());


        try {
            userDAO.create(user);
        } catch (DBException e) {
            e.printStackTrace();
        }

        //request.getSession().setAttribute("user", user);

        return new MVCModel("user created", "/Login.jsp");
    }
}
