package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by voyager on 2015.11.03..
 */
public interface MVCController {

    MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws DBException, SQLException, ServletException, Exception;
}
