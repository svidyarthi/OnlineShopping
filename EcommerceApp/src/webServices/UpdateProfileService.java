package webServices;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.SecurityManager;
import pojo.User;

@Path("/updateProfile")

public class UpdateProfileService {

	@Context HttpServletResponse servletResponse;
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

public void updateProfile(@FormParam("fname") String fname,@FormParam("lname") String lname,
			@FormParam("password") String password, @FormParam("email") String email,
			@FormParam("add1") String add1,@FormParam("add2") String add2,
			@FormParam("city") String city,@FormParam("state") String state,
			@FormParam("zip") String zip,@FormParam("country") String country,
			@FormParam("con_num") String num) throws IOException 
{

try {
User a = new User();
a.setEmail(email);
a.setPassword(password);
a.setFname(fname);
a.setLname(lname);
a.setAddress1(add1);
a.setAddress2(add2);
a.setCity(city);
a.setState(state);
a.setZip(zip);
a.setCountry(country);
a.setContact_num(num);
SecurityManager securityManager= new SecurityManager();

if(securityManager.updateProfile(a)==false){
	servletResponse.sendRedirect("/EcommerceApp/MyProfile.html?email="+email+"&result=false");
}
else{
servletResponse.sendRedirect("/EcommerceApp/MyProfile.html?email="+email+"&result=true");
}

} catch (Exception e) {
//TODO Auto-generated catch block
e.printStackTrace();
}
}

	
	
	
}
