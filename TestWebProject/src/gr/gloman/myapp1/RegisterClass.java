package gr.gloman.myapp1;

public class RegisterClass {
	public RegisterClass(String username, String fullname, String email, String password) {
		try
		{
			DatabaseAccess db = new DatabaseAccess();
			db.executeNonquery("INSERT INTO accounts (username,fullname,email,password) VALUES ('"+username+"','"+fullname+"','"+email+"','"+password+"')");
		}
		catch (Exception e)
		{
			
		}

	}
}
