package webServices;
 
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.SecurityManager;
import pojo.User;

//@Path("/WebService")
@Path("/login")

public class LoginService {

@Context HttpServletResponse servletResponse;
	
@POST
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

 public void login(@FormParam("email") String email,
 @FormParam("password") String password) throws IOException 
{
 String res=validateUser(email, password);

 if(res.contains("Logged in")){
	/* HttpSession session = new HttpSession();
	 session.setAttribute("email", email);*/
	 servletResponse.sendRedirect("/EcommerceApp/Welcome.html?email="+email);
 }
 else{
	 servletResponse.sendRedirect("/EcommerceApp/LoginForm.html?result=invalid");
 }

}
 
public String validateUser(String email, String password)
 {
	 try
	 {
		 User user = new User();
		 SecurityManager securityManager= new SecurityManager();
		 user = securityManager.getUser(email);
	
			 if(user.getEmail().equals(email))
			 {
			 if(user.getPassword().equals(password))
			 	{
				 //System.out.println(username);
				 return "Logged in User:"+email+"\n Products coming shortly";				 
			 	}
			 }
	 }
	 catch (Exception e) {
		 e.printStackTrace();
		  //System.out.println("login validation error");
	 }
	 
	 return "You are not a Valid User";
 }

}