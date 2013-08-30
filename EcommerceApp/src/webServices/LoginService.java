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
//System.out.println(res);
 if(res.contains("Logged in")){
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
					
					 if(user.getSystem_password()==1){
						 return "Logged in User:"+email+" with password reset";
					 }
					 else{
					 return "Logged in User:"+email;
					 }
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