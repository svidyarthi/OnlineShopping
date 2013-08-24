package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojo.Admin;

public class ProfileHandler {

	public Admin getProfile(Connection connection, String email) throws Exception {
		Admin a = new Admin();
		try 
		{
			 String q ="SELECT * FROM admin WHERE email='"+email+"'";
			 PreparedStatement ps = connection.prepareStatement(q);
			 ResultSet rs = ps.executeQuery();
			 if (rs.next()) 
			 {
				 a.setEmail(rs.getString("email"));
				 a.setPassword(rs.getString("password"));
				 a.setFname(rs.getString("fname"));
				 a.setLname(rs.getString("lname"));
				 a.setAddress1(rs.getString("address1"));
				 a.setAddress2(rs.getString("address2"));
				 a.setCity(rs.getString("city"));
				 a.setState(rs.getString("state"));
				 a.setZip(rs.getString("zip"));
				 a.setContact_num(rs.getString("contact_num"));
				 a.setCountry(rs.getString("country"));
				 
			 }
			 //System.out.println(userList);
			 return a;
		}
		
		catch (Exception e)
		{
			System.out.println("Handler" + e);
			throw e;
		}	}

	public Boolean updateProfile(Connection connection, Admin a) throws Exception {
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
			
			String q = "UPDATE admin SET fname='"+fname+"', lname='"+lname+"', address1='"+add1+"', address2='"+add2+"', city='"+city+"', state='"+state+"',zip='"+zip+"',contact_num='"+num+"', country='"+country+"' WHERE email = '"+email+"'";
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

}
