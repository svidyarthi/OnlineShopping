package webServices;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.SecurityManager;
import pojo.User;

@Path("/register")

public class RegisterService {

@Context HttpServletResponse servletResponse;
	
@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

 public void register(@FormParam("fname") String fname,@FormParam("lname") String lname,
		 			@FormParam("password") String password, @FormParam("emailid") String email,
		 			@FormParam("add1") String add1,@FormParam("add2") String add2,
		 			@FormParam("city") String city,@FormParam("statedd") String state,
		 			@FormParam("zip") String zip,@FormParam("country") String country,
		 			@FormParam("con_num") String num) throws IOException 
{

	 try {
			User u = new User();
			u.setEmail(email);
			u.setPassword(password);
			u.setFname(fname);
			u.setLname(lname);
			u.setAddress1(add1);
			u.setAddress2(add2);
			u.setCity(city);
			u.setState(state);
			u.setZip(zip);
			u.setCountry(country);
			u.setContact_num(num);
			SecurityManager securityManager= new SecurityManager();
			
			if(securityManager.storeUser(u)==false){
				servletResponse.sendRedirect("/EcommerceApp/Register.html?result=false");
			}
			else{
			servletResponse.sendRedirect("/EcommerceApp/LoginForm.html");
			}
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
 
}