package gr.gloman.myapp1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckUsernameServlet
 */
@WebServlet("/CheckUsernameServlet")
public class CheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUsernameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		DatabaseAccess db = new DatabaseAccess();
		ResultSet rs = db.executeReader("SELECT id FROM accounts WHERE username='"+ username+ "'");
		boolean flag_username = false;
		try {
				while (rs.next()) 
				{
					flag_username=true;
				}
		} 
		catch (Exception e) 
		{

		} finally 
		{
			db.close();
		}
		
		if(flag_username)
		{
			request.setAttribute("errorMessage", "USERNAME ALREADY EXISTS. PLEASE ENTER A DIFFERENT USER NAME.");
			//request.getRequestDispatcher("pages/RegisterPage.jsp").forward(request, response);
			//System.out.println("in");

			PrintWriter out = response.getWriter();
			out.println("USERNAME ALREADY EXISTS. PLEASE ENTER A DIFFERENT USER NAME.");
		}
		//return;
		//epistrofh me json
		
	}

}
