package gr.gloman.myapp1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

/**
 * Servlet implementation class servlerTest1
 */
//@WebServlet("/myapp")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestServlet1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String fullName = request.getParameter("fullname");
	    String password = request.getParameter("password");
	    
	    
	    
	    DatabaseAccess db = new DatabaseAccess();
	    
	    //ResultSet rs = db.executeReader("SELECT * FROM accounts");
	    ResultSet rs = db.executeReader("SELECT * FROM accounts WHERE username='"+userName.toString()+"' AND password='"+password.toString()+"'");
	    
	    String answer = "";
	    
	    try
		{
	    	boolean flagAccessAccount = false;
	    	
		while (rs.next()) {
			flagAccessAccount = true;
			//System.out.println(rs.getString("id"));
			response.getWriter().println("<h1>Hello "+rs.getString("fullname")+"!</h1>");
		}
		if(!flagAccessAccount)
		{
			response.getWriter().println("<h1>Failed login!</h1>");
		}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	    
	    db.close();
	    
		//System.out.println("Finished");
	    
		//response.getWriter().println("<h1>Hello there!</h1><br/>" );
		//response.getWriter().println();
		//response.getWriter().println(userName+"<br/>");
		//response.getWriter().println(fullName+"<br/>");
		//response.getWriter().println(password+"<br/>");
		response.getWriter().flush();
		//System.out.println("Success!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
