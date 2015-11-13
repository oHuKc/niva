package internetshop.niva.il.servlet.mvc;



import javax.servlet.http.HttpServletRequest;


/**
 * Created by ilugovecs on 2015.11.05..
 */
public class TVController implements MVCController  {

    public MVCModel execute(HttpServletRequest request) {return new MVCModel("", "/TV.jsp");}


}
