package webServices;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.multipart.FormDataParam;

import model.SecurityManager;
import pojo.Product;

@Path("/addProduct")

public class AddProductService {
	@Context HttpServletResponse servletResponse;
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	
	 public void addProduct(@FormDataParam("pic") InputStream uploadedInputStream, @FormDataParam("name") String name, @FormDataParam("cat") String cat,
			                @FormDataParam("desc") String desc,@FormDataParam("weight") BigDecimal weight,@FormDataParam("price") BigDecimal price) throws IOException 
	{
		try {
		//System.out.println("info:"+name+cat+desc+weight+price);
			
				Product p = new Product();
				p.setProductName(name);
				p.setProductCategory(cat);
				p.setProductDesc(desc);
				p.setWeight_lb(weight);
				p.setPrice(price);
		
				SecurityManager securityManager= new SecurityManager();    
				
				int pid= securityManager.addProduct(p);
				
				if(pid==0){
					servletResponse.sendRedirect("/AdminApp/AddProduct.html?result=false");
				}
				else{
				
				String uploadedFileLocation = System.getProperty("catalina.base")+"\\wtpwebapps\\AdminApp\\images\\"+pid+".jpg";
				 
				// save it
				writeToFile(uploadedInputStream, uploadedFileLocation);
		 
				  System.out.println("File uploaded to : " + uploadedFileLocation); 
				  
				/*  String clientFileLocation = System.getProperty("catalina.base")+"\\wtpwebapps\\EcommerceApp\\images\\"+pid+".jpg";
				  File adminFile = new File(uploadedFileLocation);
				  File userFile = new File(clientFileLocation);
				  FileUtils.copyFile(adminFile, userFile); */
				 
				  try {

				    	uploadedInputStream.close();
				    } catch (IOException e) {
				        e.printStackTrace();
				    }			
				
				servletResponse.sendRedirect("/AdminApp/Welcome.html");
				}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {
	 
			try {
				OutputStream out = new FileOutputStream(new File(
						uploadedFileLocation));
				int read = 0;
				byte[] bytes = new byte[1024];
	 
				out = new FileOutputStream(new File(uploadedFileLocation));
				while ((read = uploadedInputStream.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
				out.flush();
				out.close();
			} catch (IOException e) {
	 
				e.printStackTrace();
			}
	 
		}
	
}
