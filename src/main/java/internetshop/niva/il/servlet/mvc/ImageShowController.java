package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.jdbc.TVDAOImpl;
import internetshop.niva.il.domain.TV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * Created by ilugovecs on 2015.11.20..
 */

@Component
public class ImageShowController extends HttpServlet implements MVCController   {


    @Autowired
    private TVDAOImpl tv;
    private Integer ImageID = 1;


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
            throws Exception {
        return new MVCModel(getImage(request, response), "/helloWorld.jsp");
    }



}