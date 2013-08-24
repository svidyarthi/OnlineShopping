package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pojo.Product;

public class ProductsHandler {
	
	public ArrayList<Product> getAllProducts(Connection connection) throws Exception 
	{
		ArrayList<Product> productsList = new ArrayList<Product>();
		try 
		{
			 PreparedStatement ps = connection.prepareStatement("SELECT * FROM products");
			 ResultSet rs = ps.executeQuery();
			 while (rs.next()) 
			 {
				 Product p = new Product();
				 p.setProductCategory(rs.getString("productCategory"));
				 p.setProductDesc(rs.getString("productDesc"));
				 p.setProductId(rs.getInt("productId"));
				 p.setProductName(rs.getString("productName"));
				 p.setWeight_lb(rs.getBigDecimal("weight_lb"));
				 p.setPrice(rs.getBigDecimal("price"));
				 productsList.add(p);
			 }
			 //System.out.println(productsList);
			 return productsList;
		}
		
		catch (Exception e)
		{
			System.out.println("Handler" + e);
			throw e;
		}
	}
 
	public Product getProduct(Connection connection, int pID) throws Exception 
	{
		Product p = new Product();
		try 
		{
			 PreparedStatement ps = connection.prepareStatement("SELECT * FROM products WHERE productId = "+ pID);
			 ResultSet rs = ps.executeQuery();
			 while (rs.next()) 
			 {				
				 p.setProductCategory(rs.getString("productCategory"));
				 p.setProductDesc(rs.getString("productDesc"));
				 p.setProductId(rs.getInt("productId"));
				 p.setProductName(rs.getString("productName"));
				 p.setWeight_lb(rs.getBigDecimal("weight_lb"));
				 p.setPrice(rs.getBigDecimal("price"));
				 
			 }
			 //System.out.println(productsList);
			 return p;
		}
		
		catch (Exception e)
		{
			System.out.println("Handler" + e);
			throw e;
		}
	}

	
	public ArrayList<Product> getProductsByCategory(Connection connection, String category) throws Exception {
	
		ArrayList<Product> productsList = new ArrayList<Product>();
		try 
		{
			 PreparedStatement ps = connection.prepareStatement("SELECT * FROM products WHERE productCategory =" + category);
			 ResultSet rs = ps.executeQuery();
			 while (rs.next()) 
			 {
				 Product p = new Product();
				 
				 p.setProductId(rs.getInt("productId"));
				 p.setProductName(rs.getString("productName"));
				 p.setProductDesc(rs.getString("productDesc"));
				 p.setWeight_lb(rs.getBigDecimal("weight_lb"));
				 p.setPrice(rs.getBigDecimal("price"));
				 productsList.add(p);
			 }
			 //System.out.println(productsList);
			 return productsList;
		}
		
		catch (Exception e)
		{
			System.out.println("Handler" + e);
			throw e;
		}
	}
	
}
