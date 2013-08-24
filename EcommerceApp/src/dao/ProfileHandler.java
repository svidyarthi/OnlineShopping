package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojo.User;

public class ProfileHandler {

	public User getProfile(Connection connection, String email) throws Exception {
		User user = new User();
		try 
		{
			 String q ="SELECT * FROM user WHERE email='"+email+"'";
			 PreparedStatement ps = connection.prepareStatement(q);
			 ResultSet rs = ps.executeQuery();
			 if (rs.next()) 
			 {
				 user.setEmail(rs.getString("email"));
				 user.setPassword(rs.getString("password"));
				 user.setFname(rs.getString("fname"));
				 user.setLname(rs.getString("lname"));
				 user.setAddress1(rs.getString("address1"));
				 user.setAddress2(rs.getString("address2"));
				 user.setCity(rs.getString("city"));
				 user.setState(rs.getString("state"));
				 user.setZip(rs.getString("zip"));
				 user.setContact_num(rs.getString("contact_num"));
				 user.setCountry(rs.getString("country"));
				 
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
	

	public Boolean updateProfile(Connection connection, User a) throws Exception {
		// TODO Auto-generated method stub
		Boolean result = false;
		try 
		{
			String email = a.getEmail();
			String fname = a.getFname();
			String lname = a.getLname();
			String add1 = a.getAddress1();
			String add2 = a.getAddress2();
			String city = a.getCity();
			String state = a.getState();
			String zip = a.getZip();
			String num = a.getContact_num();
			String country = a.getCountry();	
			
			String q = "UPDATE user SET fname='"+fname+"', lname='"+lname+"', address1='"+add1+"', address2='"+add2+"', city='"+city+"', state='"+state+"',zip='"+zip+"',contact_num='"+num+"', country='"+country+"' WHERE email = '"+email+"'";
			//System.out.println(q);
			 PreparedStatement ps = connection.prepareStatement(q);
			 ps.executeUpdate();	
			 result=true;
        
}
catch (Exception e)
{
	System.out.println("Handler" + e);
	throw e;
}
return result;		

	}


	public Boolean updatePassword(Connection connection, String email, String password) throws Exception{
	
		Boolean result = false;
		try 
		{
			String q = "UPDATE user SET password='"+password+"' WHERE email = '"+email+"'";
			PreparedStatement ps = connection.prepareStatement(q);
			ps.executeUpdate();	
			result=true;
		        
		}
		catch (Exception e)
		{
			System.out.println("Handler" + e);
			throw e;
		}
		return result;		
	}
}

