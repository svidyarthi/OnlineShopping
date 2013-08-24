package model;

import java.sql.Connection;
import java.util.ArrayList;

import pojo.Product;
import pojo.Admin;

import dao.DbConnection;
import dao.LoginHandler;
import dao.ProductsHandler;
import dao.ProfileHandler;

public class SecurityManager {
	
	DbConnection database;
	Connection connection;
	
	public SecurityManager(){
		try {
			database= new DbConnection();
			connection = database.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Admin getAdmin(String email)throws Exception {
		Admin ad = new Admin();
		try {
			LoginHandler loginHandler= new LoginHandler();
			ad = loginHandler.getAdmin(connection, email);
		
			} catch (Exception e) {
				throw e;
				}
			return ad;
	}
	
	public ArrayList<Product> getAllProductsList()throws Exception {
		ArrayList<Product> productsList = null;
		try {
			ProductsHandler productsHandler= new ProductsHandler();
			productsList = productsHandler.getAllProducts(connection);
		
			} catch (Exception e) {
				throw e;
				}
			return productsList;
	}

	public int addProduct(Product p) throws Exception {
		try {
			ProductsHandler pHandler= new ProductsHandler();
			int result = pHandler.addProduct(connection, p);
			return result;
			} catch (Exception e) {
				throw e;
				}
		}

	public Product getProduct(int pId) throws Exception{
		Product product = new Product();
		try {
			ProductsHandler productsHandler= new ProductsHandler();
			product = productsHandler.getProduct(connection, pId);
		
			} catch (Exception e) {
				throw e;
				}
			return product;
	}

	public int updateProduct(Product p) throws Exception {
		try 
		{
			ProductsHandler pHandler= new ProductsHandler();
			int result = pHandler.updateProduct(connection, p);
			return result;
		} 
		catch (Exception e) {
				throw e;
		}
	}

	public Admin getProfile(String email) throws Exception {
		Admin user = new Admin();
		try {
			ProfileHandler profileHandler= new ProfileHandler();
			user = profileHandler.getProfile(connection, email);
		
			} catch (Exception e) {
				throw e;
				}
			return user;
		}

	public int deleteProduct(int pId) throws Exception {
		// TODO Auto-generated method stub
		int result=0;
		try{
			ProductsHandler p = new ProductsHandler();
			result = p.deleteProduct(connection, pId);
			
		}catch (Exception e) {
			throw e;
			}
		return result;
	}

	public boolean updateProfile(Admin a) throws Exception{
		Boolean result = false;
		try {
			ProfileHandler profileHandler= new ProfileHandler();
			result = profileHandler.updateProfile(connection, a);
		
			} catch (Exception e) {
				throw e;
				}
			return result;
	}
}