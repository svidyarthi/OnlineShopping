package webServices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/cart")
public class SesssionService {

    @GET
    @Produces("text/plain")
    public String hello(@Context HttpServletRequest req) {

    	HttpSession session= req.getSession(true);
    	Object foo = session.getAttribute("foo");
    	if (foo!=null) {
    		System.out.println(foo.toString());
    	} else {
    		foo = "bar";
    		session.setAttribute("foo", "bar");
    	}
    	
    	return foo.toString();


    }
}