package webServices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.SecurityManager;
import pojo.Product;

@Path("/products")
public class ProductsService {

	//display xml file on browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Product> getProductsOnBrowser() {
		List<Product> products = new ArrayList<Product>();
		 SecurityManager securityManager= new SecurityManager();
		 try {
			products = securityManager.getAllProductsList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	// xml for rest call
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		 SecurityManager securityManager= new SecurityManager();
		 try {
			products = securityManager.getAllProductsList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	@Path("/{pId}")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Product getProduct(@PathParam("pId") String pId) {
		 Product product = new Product();
		 SecurityManager securityManager= new SecurityManager();
		 try {
			 Integer pID = Integer.parseInt(pId);
			product = securityManager.getProduct(pID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	
	@Path("/{pId}/{category}")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Product> getProductsByCategory(@PathParam("category") String category) {
	
		List<Product> products = new ArrayList<Product>();
		 SecurityManager securityManager= new SecurityManager();
		 try {
			 if(category.equals("All")){
				 products = securityManager.getAllProductsList(); 
			 }
			 else {
			products = securityManager.getProductsListByCategory(category);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
}