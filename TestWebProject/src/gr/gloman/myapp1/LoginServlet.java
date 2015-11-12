package gr.gloman.myapp1;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String password = request.getParameter("password");
		
		LoginClass login = new LoginClass();
		int id = login.LoginGetId(username, password);
		
		if(id!=0)
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			DatabaseAccess db = new DatabaseAccess();
			ResultSet rs = db.executeReader("SELECT fullname FROM accounts WHERE id="+id+"");
			String fullname = "";
			try
			{
				while(rs.next())
				{
					 fullname = rs.getString("fullname");
				}
			}catch (Exception e)
			{
				
			}
			finally
			{
				db.close();
			}
			session.setAttribute("fullname", fullname);
			RequestDispatcher dispatcher = request.getRequestDispatcher("pages/MemberPage.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("errorToLoginMessage","Login Failed.");
			request.getRequestDispatcher("pages/LoginPage.jsp").forward(request, response);
		}
		
	}

}
