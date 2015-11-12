package gr.gloman.myapp1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		if(password.equals(confirmPassword))
		{
			String username = request.getParameter("username");
			String fullname = request.getParameter("fullname");
			String email = request.getParameter("email");
			HttpSession session = request.getSession();
			session.setAttribute("fullname", fullname);
			RegisterClass register = new RegisterClass(username, fullname, email, confirmPassword);
			RequestDispatcher dispatcher = request.getRequestDispatcher("pages/MemberPage.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("errorMessage","Passwords do not match.");
			//response.sendRedirect(request.getContextPath() + "/pages/RegisterPage.jsp");
			
			//RequestDispatcher dispatcher = request.getRequestDispatcher("pages/RegisterPage.jsp");
			//dispatcher.forward(request, response);
			request.getRequestDispatcher("pages/RegisterPage.jsp").forward(request, response);
			
		}
	}

}
