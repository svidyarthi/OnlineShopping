package webServices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.JResponse;

import model.SecurityManager;
import pojo.Product;

@Path("/products")
public class ProductsService {

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

	@Path("category")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Product> getProductsByCategory(String category) {
		List<Product> products = new ArrayList<Product>();
		 SecurityManager securityManager= new SecurityManager();
		 try {
			products = securityManager.getProductsListByCategory(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
}
