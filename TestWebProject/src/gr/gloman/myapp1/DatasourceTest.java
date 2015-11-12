package gr.gloman.myapp1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DatasourceTest {


	 public static void main(String[] args) {
		 
		 Connection connection = null;

		try {
			DriverManager.registerDriver((Driver) Class.forName(
					"com.microsoft.sqlserver.jdbc.SQLServerDriver")
					.newInstance());
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			System.out.println("4!");
			ResultSet rs = null;
			System.out.println("2!");
			SQLServerDataSource dataSource = new SQLServerDataSource();

			dataSource.setUser("live24_check");
			dataSource.setPassword("1231234");
			//dataSource.setServerName("RADIOMIX-1-HP/SQLEXPRESS://127.0.0.1");
			dataSource.setServerName("127.0.0.1");
			dataSource.setDatabaseName("dbjsp");

			connection = dataSource.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM accounts");
			// statement.setLong(1, sid);
			rs = statement.executeQuery();
			// for every row, call read method to extract column
			// values and place them in a coursesummary instance
			System.out.println("3!");
			while (rs.next()) {
				System.out.println(rs.getString("id"));
			}

			// System.out.println("3!");
			// Connection conn =
			// DriverManager.getConnection("jdbc:RADIOMIX-1-HP/SQLEXPRESS://127.0.0.1;databaseName=dbjsp","live24_check","1231234");
			// System.out.println("2!");
			// PreparedStatement pps =
			// conn.prepareStatement("SELECT * FROM accounts");
			// ResultSet rs = pps.executeQuery();
			// while(rs.next()){
			// do something
			// System.out.println(rs.getString("some col"));
			// }
			// close connection
			// conn.close();
		} catch (Exception ex) {
			
			// do something
			ex.printStackTrace();
			System.out.println(ex);
		}
		finally {
			if ( connection != null ) {
				try { connection.close(); } catch (Exception e) {} 
			}
		}
		
		System.out.println("Finished"); 
	}

}
