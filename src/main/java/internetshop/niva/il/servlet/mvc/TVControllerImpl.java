package internetshop.niva.il.servlet.mvc;



import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.jdbc.TVDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by ilugovecs on 2015.11.05..
 */
@Component
public class TVControllerImpl implements MVCController  {

    @Autowired @Qualifier("TVDAOImpl_JDBC")
    private TVDAOImpl tv;
    private Integer ImageID = 0;

    private Integer getImage(HttpServletRequest req,
                             HttpServletResponse resp) throws
            ServletException, IOException, DBException, SQLException {
        Connection connection = null;
        if (req.getParameter("imgID") != null) {
            try {
                ImageID = Integer.parseInt(req.getParameter("imgID"));
                byte[] imgData = tv.getImage(ImageID);
                resp.setContentType("image/jpeg");
                OutputStream outputStream = resp.getOutputStream();
                outputStream.write(imgData);
                resp.getOutputStream().flush();
                resp.getOutputStream().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ImageID;
    }



    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws DBException, SQLException, ServletException, IOException {
        return new MVCModel(getImage(request, response), "/TV.jsp");
    }

}
