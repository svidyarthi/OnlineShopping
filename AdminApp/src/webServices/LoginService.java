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
import pojo.Admin;

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
	 servletResponse.sendRedirect("/AdminApp/Welcome.html?email="+email);
 }
 else{
	 servletResponse.sendRedirect("/AdminApp/LoginForm.html?result=invalid");
 }

}
 
public String validateUser(String email, String password)
 {
	 try
	 {
		 Admin admin = new Admin();
		 SecurityManager securityManager= new SecurityManager();
		 admin = securityManager.getAdmin(email);
	
			 if(admin.getEmail().equals(email))
			 {
			 if(admin.getPassword().equals(password))
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