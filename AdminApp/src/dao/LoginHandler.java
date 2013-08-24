	package dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	 
	import pojo.Admin;
	 
	public class LoginHandler
	{
	 
		public Admin getAdmin(Connection connection, String email) throws Exception 
		{
			Admin admin = new Admin();
			try 
			{
				 String q ="SELECT * FROM admin WHERE email='"+email+"'";
				 PreparedStatement ps = connection.prepareStatement(q);
				 ResultSet rs = ps.executeQuery();
				 if (rs.next()) 
				 {
					 admin.setEmail(rs.getString("email"));
					 admin.setPassword(rs.getString("password"));
				 }
				 //System.out.println(userList);
				 return admin;
			}
			
			catch (Exception e)
			{
				System.out.println("Handler" + e);
				throw e;
			}
		}
		
	
}
