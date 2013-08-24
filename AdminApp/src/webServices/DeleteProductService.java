package webServices;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.SecurityManager;
import pojo.Product;

import javax.ws.rs.FormParam;

@Path("/deleteProduct")
public class DeleteProductService {
	
@Context HttpServletResponse servletResponse;
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	
	 public void deleteProduct(@FormParam("pid") String id) throws IOException 
     {
		try {
	System.out.println("id:"+id);
	
	int pId = (Integer.parseInt(id));

	SecurityManager securityManager= new SecurityManager();    
	
	int result= securityManager.deleteProduct(pId);
	
	if(result==0){
		servletResponse.sendRedirect("/AdminApp/EditProduct.html?result=false");
	}
	else{
	
	servletResponse.sendRedirect("/AdminApp/Welcome.html");
	}
	
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	

}
