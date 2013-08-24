package webServices;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.SecurityManager;
import pojo.User;

@Path("/resetPassword")

public class PasswordService {

@Context HttpServletResponse servletResponse;
	
@POST
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

 public void resetPassword(@FormParam("email") String email) throws Exception 
{
try {
	String res=validateUser(email);

	if(res.contains("Valid User:"))
	{
	/* HttpSession session = new HttpSession();
	 session.setAttribute("email", email);*/
	 
		 PasswordResetMailService m = new PasswordResetMailService(); 
		 String temp = m.sendMail(email);
		 updatePassword(email, temp);
	
		 servletResponse.sendRedirect("/EcommerceApp/LoginForm.html?reset=true");
	}
	
 else{
	 servletResponse.sendRedirect("/EcommerceApp/ResetPassword.html?result=false");
 }
}
catch(Exception e){
	e.printStackTrace();
}
}

private Boolean updatePassword(String email, String password) throws Exception{
	Boolean result = false;
	SecurityManager securityManager= new SecurityManager();
	result = securityManager.updatePassword(email,password);
	return result;
}

private String validateUser(String email) {
	 try
	 {
		 User user = new User();
		 SecurityManager securityManager= new SecurityManager();
		 user = securityManager.getUser(email);
	
			 if(user.getEmail().equals(email))
			 {
				 return "Valid User:"+email;				 		 	
			 }
	 }
	 catch (Exception e) {
		 e.printStackTrace();
	 }	 
	 return "You are not a Valid User";
}

}
