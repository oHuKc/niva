package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.DBException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by ilugovecs on 2016.01.18..
 */
@Component
public class LoginWelcomeControllerImpl extends HttpServlet implements LoginWelcomeController{



    public MVCModel execute(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return new MVCModel("", "/Login_Welcome.jsp");
    }
}
