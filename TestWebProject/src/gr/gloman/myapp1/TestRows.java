package gr.gloman.myapp1;

public class TestRows {
	public String username = "";
	public String fullname = "";

	public TestRows(String username_, String fullname_) {
		try 
		{
			username = username_;
			fullname = fullname_;
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	
	public String toString()
	{
		
		return fullname + " " + username;
		
	}
	
	//public String username()
	//{
		
	//	return username;
		
	//}
	
	public String getusername()
	{
		return username;
	}
	
	public String getfullname()
	{
		return fullname;
	}
	
}
