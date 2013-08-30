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
import pojo.Admin;

@Path("/updatePassword")

public class UpdatePasswordService {
	
	@Context HttpServletResponse servletResponse;
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	
	public void updateProfile(@FormParam("email") String email,
			@FormParam("password") String password, @FormParam("newpass") String newpass) throws IOException 
{

try {	
	Boolean res=validateUser(email, password);

	 if(res==true){
		/* HttpSession session = new HttpSession();
		 session.setAttribute("email", email);*/
		 
		 if(updatePassword(email,newpass,0)==true){	

			 
			 servletResponse.sendRedirect("/AdminApp/ChangePassword.html?result=done");
			 }
		 
	 }
	 else{
		 servletResponse.sendRedirect("/AdminApp/ChangePassword.html?result=invalid");
	 }

	} catch (Exception e) {
		//TODO Auto-generated catch block
		e.printStackTrace();
		}
}
	 
	public Boolean validateUser(String email, String password)
	 {
		Boolean result=false;
		 try
		 {
			 Admin user = new Admin();
			 SecurityManager securityManager= new SecurityManager();
			 user = securityManager.getAdmin(email);
		
				 if(user.getEmail().equals(email))
				 {
				 if(user.getPassword().equals(password))
				 	{
					 //System.out.println(username);
					 result=true;				 
				 	}
				 }
		 }
		 catch (Exception e) {
			 e.printStackTrace();
			  //System.out.println("login validation error");
		 }
		 return result;
	 }
	
	
	private Boolean updatePassword(String email, String password, int reset) throws Exception{
		Boolean result = false;
		SecurityManager securityManager= new SecurityManager();
		result = securityManager.updatePassword(email,password,0);
		return result;
	}
	
}
