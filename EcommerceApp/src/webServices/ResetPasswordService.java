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

public class ResetPasswordService {

@Context HttpServletResponse servletResponse;
	
@POST
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

 public void resetPassword(@FormParam("email") String email) throws Exception 
{
try {
	Boolean res=validateUser(email);

	if(res==true)
	{
	/* HttpSession session = new HttpSession();
	 session.setAttribute("email", email);*/
	 
		 PasswordResetMailService m = new PasswordResetMailService(); 
		 String temp = m.sendMail(email);
		 if(updatePassword(email, temp)==true){	
		 servletResponse.sendRedirect("/EcommerceApp/LoginForm.html?reset=true");
		 }
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
	result = securityManager.updatePassword(email,password,1);
	return result;
}

private Boolean validateUser(String email) {
	Boolean result=false;
	 try
	 {
		 User user = new User();
		 SecurityManager securityManager= new SecurityManager();
		 user = securityManager.getUser(email);
	
			 if(user.getEmail().equals(email))
			 {
				 result=true;				 		 	
			 }
			 else
			 {
				 result=false;
			 }
	 }
	 catch (Exception e) {
		 e.printStackTrace();
	 }	 	
	 return result;
}

}
