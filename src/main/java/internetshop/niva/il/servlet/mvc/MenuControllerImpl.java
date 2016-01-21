package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.TVDAO;
import internetshop.niva.il.database.jdbc.TVDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by voyager on 2015.11.03..
 */
//@Component
@Controller
public class MenuControllerImpl{

    @Autowired
    @Qualifier( value = "TVDAOImpl_Hibernate")
    private TVDAO tvdao;

    public String doGetmMenu(HttpServletRequest req, HttpServletResponse resp)
            throws DBException {

        //Set session ID
        HttpSession session = req.getSession();
        // System.out.print("Session ID jsp: " +session.getAttribute("sessionId")+"\n");
       session.setAttribute("sID", session.getId());
       System.out.print("Session ID: " + session.getId()+"\n");


if (session.getAttribute("sID") != null) {
    //Menu
    String uhd1 = String.valueOf(tvdao.get4KUHD(1).get(0).getTvscreensize());
    String uhd2 = String.valueOf(tvdao.get4KUHD(2).get(0).getTvscreensize());
    String uhd3 = String.valueOf(tvdao.get4KUHD(3).get(0).getTvscreensize());
    String uhd4 = String.valueOf(tvdao.get4KUHD(4).get(0).getTvscreensize());
    String uhd5 = String.valueOf(tvdao.get4KUHD(5).get(0).getTvscreensize());
    String uhd6 = String.valueOf(tvdao.get4KUHD(6).get(0).getTvscreensize());
    String uhd7 = String.valueOf(tvdao.get4KUHD(7).get(0).getTvscreensize());
    String uhd10 = String.valueOf(tvdao.get4KUHD(10).get(0).getTvscreensize());
    String uhd11 = String.valueOf(tvdao.get4KUHD(11).get(0).getTvscreensize());
    String uhd12 = String.valueOf(tvdao.get4KUHD(12).get(0).getTvscreensize());
    String uhd13 = String.valueOf(tvdao.get4KUHD(13).get(0).getTvscreensize());
    String uhd14 = String.valueOf(tvdao.get4KUHD(14).get(0).getTvscreensize());
    String uhd15 = String.valueOf(tvdao.get4KUHD(15).get(0).getTvscreensize());
    String uhd16 = String.valueOf(tvdao.get4KUHD(16).get(0).getTvscreensize());
    String uhd17 = String.valueOf(tvdao.get4KUHD(17).get(0).getTvscreensize());
    String uhd18 = String.valueOf(tvdao.get4KUHD(18).get(0).getTvscreensize());
    String uhd19 = String.valueOf(tvdao.get4KUHD(19).get(0).getTvscreensize());


    req.setAttribute("4kid1", uhd1);
    req.setAttribute("4kid2", uhd2);
    req.setAttribute("4kid3", uhd3);
    req.setAttribute("4kid4", uhd4);
    req.setAttribute("4kid5", uhd5);
    req.setAttribute("4kid6", uhd6);
    req.setAttribute("4kid7", uhd7);
    req.setAttribute("4kid10", uhd10);
    req.setAttribute("4kid11", uhd11);
    req.setAttribute("4kid12", uhd12);
    req.setAttribute("4kid13", uhd13);
    req.setAttribute("4kid14", uhd14);
    req.setAttribute("4kid15", uhd15);
    req.setAttribute("4kid16", uhd16);
    req.setAttribute("4kid17", uhd17);
    req.setAttribute("4kid18", uhd18);
    req.setAttribute("4kid19", uhd19);
        }
        return null;
    }
/*
    @Transactional
    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws DBException {
        return  new MVCModel(doGetmMenu(request, response), "/Menu.jsp");
    }
*/
    @RequestMapping(value = "/menu", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, DBException {

        return new ModelAndView("/Menu.jsp", "model", doGetmMenu(request, response));
    }
}
