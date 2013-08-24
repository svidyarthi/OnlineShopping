package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
			 connection.close();
			 return productsList;
		}
		
		catch (Exception e)
		{
			System.out.println("Handler" + e);
			throw e;
		}
	}

	public int addProduct(Connection c, Product p) throws Exception
		{
			int pid=0;
			try 
			{
				String name = p.getProductName();
				String cat = p.getProductCategory();
				String desc = p.getProductDesc();
				BigDecimal weight = p.getWeight_lb();
				BigDecimal price = p.getPrice();
								
				String q1 = "SELECT MAX(productId) AS max FROM products";
				PreparedStatement ps1 = c.prepareStatement(q1);
				ResultSet RS = ps1.executeQuery(q1);
				int results=0;
		        while (RS.next()) {
		            results= results+RS.getInt("max");
		            } 
		         pid=(results+1);
		                
		            	String q = "INSERT INTO products VALUES('"+pid+"','"+name+"','"+cat+"','"+desc+"',"+weight+","+price+")";
						//System.out.println(q);
						 PreparedStatement ps = c.prepareStatement(q);
						 ps.executeUpdate();
						 c.close();			 
		            
			}
			catch (Exception e)
			{
				System.out.println("Handler" + e);
				throw e;
			}
			return pid;
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
				 connection.close();
				 return p;
			}
			
			catch (Exception e)
			{
				System.out.println("Handler" + e);
				throw e;
			}
		}

		public int updateProduct(Connection connection, Product p) throws Exception {
			
			int pid=0;
			try 
			{
				pid = p.getProductId();
				String name = p.getProductName();
				String cat = p.getProductCategory();
				String desc = p.getProductDesc();
				BigDecimal weight = p.getWeight_lb();
				BigDecimal price = p.getPrice();
								
		                
		         String q = "UPDATE products SET productName='"+name+"', productCategory='"+cat+"', productDesc='"+desc+"', weight_lb="+weight+", price="+price+" WHERE productId = "+pid;
						//System.out.println(q);
				 PreparedStatement ps = connection.prepareStatement(q);
				 ps.executeUpdate();					 
		            
			}
			catch (Exception e)
			{
				System.out.println("Handler" + e);
				throw e;
			}
			return pid;		
			
		}

		
		public int deleteProduct(Connection connection, int pId) throws Exception {
			int result=0;
			Statement st = null;
			try 
			{           
		         String q = "DELETE FROM products WHERE productId = "+pId;
						//System.out.println(q);
				 st = connection.createStatement();
				 result = st.executeUpdate(q);
		          connection.close();
			}
			catch (Exception e)
			{
				System.out.println("Handler" + e);
				throw e;
			}
			return result;	
			
		}
}		
