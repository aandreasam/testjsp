package gr.gloman.myapp1;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;


public class DatabaseAccess {

	static ResultSet rs = null;
	Connection connection = null;
	public DatabaseAccess()
	{
		
	}
//"SELECT * FROM accounts"
	public ResultSet executeReader(String query)
	{
		//System.out.println("Start!");
		//System.out.println(query);
		try
		{
			DriverManager.registerDriver((Driver) Class.forName(
					"com.microsoft.sqlserver.jdbc.SQLServerDriver")
					.newInstance());

			//System.out.println("4!");
			//System.out.println("2!");
			SQLServerDataSource dataSource = new SQLServerDataSource();

			dataSource.setUser("live24_check");
			dataSource.setPassword("1231234");
			
			dataSource.setServerName("127.0.0.1");
			dataSource.setDatabaseName("dbjsp");

			connection = dataSource.getConnection();
			PreparedStatement statement = connection
					.prepareStatement(query);
			
			rs = statement.executeQuery();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex);
		}
		finally
		{
		}
		
		return rs;
	}
	
	public void close()
	{
		if ( connection != null ) {
		try { connection.close(); } catch (Exception e) {} 
		}
	}
	
	public void executeNonquery(String query)
	{
		try
		{
			//System.out.println(query);
			PreparedStatement statement =null;
			DriverManager.registerDriver((Driver) Class.forName(
					"com.microsoft.sqlserver.jdbc.SQLServerDriver")
					.newInstance());
			
			SQLServerDataSource dataSource = new SQLServerDataSource();

			dataSource.setUser("live24_check");
			dataSource.setPassword("1231234");
			
			dataSource.setServerName("127.0.0.1");
			dataSource.setDatabaseName("dbjsp");

			connection = dataSource.getConnection();
			statement = connection
					.prepareStatement(query);
			
			statement.executeUpdate();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex);
		}
		finally
		{
			if ( connection != null ) {
			try { connection.close(); } catch (Exception e) {} 
			}
		}

	}
}
