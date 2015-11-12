package gr.gloman.myapp1;

import java.awt.List;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletRedirect
 */
//@WebServlet("/ServletRedirect")
public class ServletRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRedirect() {
        super();
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
		response.sendRedirect("pages/SecondPage.jsp?username="+userName+"&fullname="+fullName);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
	     session.setAttribute("name", "session scoped attribute");
		DatabaseAccess db = new DatabaseAccess();
		
		ArrayList<TestRows> rows = new ArrayList<TestRows>(); 
		
		ResultSet rs = db.executeReader("SELECT * FROM accounts");
		try
		{
			
		while (rs.next()) {
			TestRows row = new TestRows(rs.getString("username"), rs.getString("fullname"));
			//System.out.println(row.username+" "+row.fullname);
			rows.add(row);
		}
		}catch(Exception e)
		{
			System.out.println("excp");
			System.out.println(e.toString());
		}
		
		try
		{
			session.setAttribute("resultList", rows);
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		 
	     
	     
	     
	     db.close();
	     
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/SecondPage.jsp");
		dispatcher.forward(request, response);
		//DatabaseAccess db = new DatabaseAccess();
		//db.executeNonquery("INSERT INTO accounts (username,fullname,password) VALUES ('"+userName+"','"+fullName+"','"+password+"')");
		
		
		//System.out.println(fullName);
	    
	}

}
