	package model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import pojo.Product;
import pojo.User;
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

	public User getUser(String email)throws Exception {
		User user = new User();
		try {
			LoginHandler loginHandler= new LoginHandler();
			user = loginHandler.getUser(connection, email);
		
			} catch (Exception e) {
				throw e;
				}
			return user;
	}
	
	public Boolean storeUser(User u)throws Exception {
		
		try {
			LoginHandler loginHandler= new LoginHandler();
			Boolean result = loginHandler.storeUser(connection, u);
			return result;
			} catch (Exception e) {
				throw e;
				}
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

	public User getProfile(String email) throws Exception {
		User user = new User();
		try {
			ProfileHandler profileHandler= new ProfileHandler();
			user = profileHandler.getProfile(connection, email);
		
			} catch (Exception e) {
				throw e;
				}
			return user;
	}

	public boolean updateProfile(User a) throws Exception {
		Boolean result = false;
		try {
			ProfileHandler profileHandler= new ProfileHandler();
			result = profileHandler.updateProfile(connection, a);
		
			} catch (Exception e) {
				throw e;
				}
			return result;
	}

	public List<Product> getProductsListByCategory(String category) throws Exception {
		ArrayList<Product> productsList = null;
		try {
			ProductsHandler productsHandler= new ProductsHandler();
			productsList = productsHandler.getProductsByCategory(connection, category);
		
			} catch (Exception e) {
				throw e;
				}
			return productsList;
	}

	public Boolean updatePassword(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		Boolean result = false;
		try {
			ProfileHandler profileHandler= new ProfileHandler();
			result = profileHandler.updatePassword(connection, email, password);
		
			} catch (Exception e) {
				throw e;
				}
			return result;
	}
}