package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public Connection getConnection() throws Exception
	 {
	 try
	 	{
		 String connectionURL = "jdbc:mysql://localhost:3306/ecommerce";
		 Connection connection = null;
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
		 connection = DriverManager.getConnection(connectionURL, "root", "root");
		 //System.out.println("mysql connection successful");
		 return connection;
	 	}
	 catch (SQLException e)
	 	{
		 System.out.println("sql db conn fail"+e);
		 throw e;
	 	}
	 catch (Exception e)
	 	{
		 System.out.println("db conn fail"+e);
		 throw e;
	 	}
	 }
}
