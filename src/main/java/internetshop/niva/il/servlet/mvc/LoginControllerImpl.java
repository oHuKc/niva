package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.UserDAO;
import internetshop.niva.il.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by vitanovo on 07.12.2015.
 */
//@Component
@Controller
public class LoginControllerImpl {

    @Autowired
    @Qualifier(value = "UserDAO_HIBERNATE")
    private UserDAO userDAO;


    public String dogetUser(HttpServletRequest request, HttpServletResponse response)
            throws DBException {

        HttpSession session = request.getSession();

        if (session.getAttribute("sID") != null) {
            String login = (String) request.getParameter("login");
            String email = (String) request.getParameter("InputEmail1");
            String firstName = (String) request.getParameter("inputName");
            String lastName = (String) request.getParameter("inputSurname");
            String pass = (String) request.getParameter("InputPassword1");

            User user = new User();
            user.setLogin(login);
            user.setPassword(pass);
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);

            System.out.println(user.getPassword());

            if (request.getParameter("login") != null) {
                userDAO.create(user);

                System.out.println("Registered login: " + login);
                System.out.println("Registered password: " + email);

               // if (userDAO.alreadyExists(login) == true) {
               //    System.out.print("Username already exist!"+"\n");
                    //userDAO.delete(user);
              // }else {userDAO.create(user);}
            }


            return user.toString();
         }
        return null;
        }

/*
    @Transactional
    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws DBException, SQLException, ServletException, Exception {
        return new MVCModel(dogetUser(request, response), "/Login.jsp");
    }
*/
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response)
            throws DBException {
        return new ModelAndView("/Login.jsp", "model", dogetUser(request, response));
    }
}
