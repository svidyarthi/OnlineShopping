	package dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	 
	import pojo.User;
	 
	public class LoginHandler
	{
	 
		public User getUser(Connection connection, String email) throws Exception 
		{
			User user = new User();
			try 
			{
				 String q ="SELECT email,password FROM user WHERE email='"+email+"'";
				 PreparedStatement ps = connection.prepareStatement(q);
				 ResultSet rs = ps.executeQuery();
				 if (rs.next()) 
				 {
					 user.setEmail(rs.getString("email"));
					 user.setPassword(rs.getString("password"));
				 }
				 //System.out.println(userList);
				 return user;
			}
			
			catch (Exception e)
			{
				System.out.println("Handler" + e);
				throw e;
			}
		}
		
		
		public Boolean storeUser(Connection c, User u) throws Exception
		{
			Boolean result = false;
			try 
			{
				String email = u.getEmail();
				String fname = u.getFname();
				String lname = u.getLname();
				String pwd = u.getPassword();
				String add1 = u.getAddress1();
				String add2 = u.getAddress2();
				String city = u.getCity();
				String state = u.getState();
				String zip = u.getZip();
				String num = u.getContact_num();
				String country = u.getCountry();			
				
				String q1 = "SELECT COUNT(*) AS total FROM user where email ='"+email+"'";
				PreparedStatement ps1 = c.prepareStatement(q1);
				ResultSet RS = ps1.executeQuery(q1);
		        while (RS.next()) {
		            if( RS.getInt("total") > 0 ) {
		                // user already exists
		            	result = false;
		            } else {
		                // user does not exist
		            	String q = "INSERT INTO user VALUES('"+email+"','"+pwd+"','"+fname+"','"+lname+"','"+add1+"','"+add2+"','"+city+"','"+state+"','"+zip+"','"+num+"','"+country+"')";
						//System.out.println(q);
						 PreparedStatement ps = c.prepareStatement(q);
						 ps.executeUpdate();
						 result = true;
		            }
		        }		
			}
			catch (Exception e)
			{
				System.out.println("Handler" + e);
				throw e;
			}
			return result;
		}
		
	}
