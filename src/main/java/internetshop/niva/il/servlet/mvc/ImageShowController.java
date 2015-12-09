package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.TVDAO;
import internetshop.niva.il.database.jdbc.TVDAOImpl;
import internetshop.niva.il.domain.TV;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
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


    @Autowired @Qualifier(value = "TVDAOImpl_Hibernate")
    private TVDAO tvdao;
    private Integer ImageID = null;

    @Transactional
    private Integer getImage(HttpServletRequest req,
                             HttpServletResponse resp) throws
            HibernateException, IOException, DBException, SQLException {
        Connection connection = null;
        if (req.getParameter("imgID") != null) {
            try {
                ImageID = Integer.parseInt(req.getParameter("imgID"));
                byte[] imgData = tvdao.getImage(ImageID);
                resp.setContentType("image/jpeg");
                OutputStream outputStream = resp.getOutputStream();
                outputStream.write(imgData);
                resp.getOutputStream().flush();
                resp.getOutputStream().close();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return ImageID;
    }




    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws DBException, SQLException, ServletException, IOException {
       return new MVCModel(getImage(request, response), "/helloWorld.jsp");
       // return new MVCModel(imageTest(request, response), "/helloWorld.jsp");
    }



}