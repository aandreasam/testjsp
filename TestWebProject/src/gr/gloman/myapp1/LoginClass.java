package gr.gloman.myapp1;

import java.sql.ResultSet;

public class LoginClass {

	public LoginClass()
	{
	}
	
	public int LoginGetId(String username, String password)
	{
		DatabaseAccess db = new DatabaseAccess();
		ResultSet rs = db.executeReader("SELECT id FROM accounts WHERE username='"+username+"' AND password='"+password+"'");
		int id=0;
		try
		{
			while(rs.next())
			{
				id = rs.getInt("id");
			}
		}
		catch (Exception e)
		{
		}
		finally
		{
			db.close();
		}
		return id;
	}
}
