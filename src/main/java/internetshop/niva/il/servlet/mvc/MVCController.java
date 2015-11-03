package internetshop.niva.il.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by voyager on 2015.11.03..
 */
public interface MVCController {

    MVCModel execute(HttpServletRequest request);
}
