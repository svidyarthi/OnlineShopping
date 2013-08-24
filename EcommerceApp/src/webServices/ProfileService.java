package webServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.SecurityManager;
import pojo.User;

@Path("/profile/{email}")
public class ProfileService {
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public User getProfile(@PathParam("email") String email) {
		User user = new User();
		 SecurityManager securityManager= new SecurityManager();
		 try {
			user = securityManager.getProfile(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
}
