package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.LoginWelcomeDAO;
import internetshop.niva.il.database.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.SQLException;

/**
 * Created by ilugovecs on 2016.01.18..
 */
//@Component
@Controller
public class LoginWelcomeControllerImpl {

    @Autowired
    @Qualifier(value = "LoginWelcomeDAO_Hibernate")
    private LoginWelcomeDAO logindao;

    @Autowired
    @Qualifier(value = "UserDAO_HIBERNATE")
    private UserDAO userdao;

    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public String doLogin(HttpServletRequest req, HttpServletResponse resp) throws DBException,
            ServletException, IOException {

        if((req.getParameter("login") != null) && (req.getParameter("password") != null ))
        {
            String username = req.getParameter("login");
            String password = req.getParameter("password");

            String welcomelogin = String.valueOf(logindao.getUserLogin(username).getLogin());
            String welcomepassword = String.valueOf(logindao.getUserLogin(username).getPassword());

           //System.out.print("Entered Login and password: " + username + "  " + password + "\n");
           //System.out.print("Login and password from DB: " + welcomelogin + "  " + welcomepassword + "\n");

            if ( password.equals(welcomepassword) == false  ) {

                req.setAttribute("wrongpassword", "Wrong password or login . Try again."+ "\n");

               //System.out.print("Wrong password ! Try again." + "\n");

            } else {

                req.setAttribute("welcome", "Login and Password are correct. Welcome." +"\n");

              //System.out.print("Login and Password are correct. Welcome." +"\n");

                resp.sendRedirect("http://"+InetAddress.getLocalHost().getHostAddress()+":8080"+"/java2/orderstatus");

                HttpSession session = req.getSession();

                session.setAttribute("loggedin", 1);
            }

        }

        return  null;
    }
/*
    public MVCModel execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new MVCModel(doLogin(request, response), "/Login_Welcome.jsp");
    }
*/
    @RequestMapping(value = "/welcome", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DBException {

        return new ModelAndView("Login_Welcome.jsp", "model", doLogin(request, response));
    }
 }
