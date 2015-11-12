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
 * Servlet implementation class ServletAboutNewVersion
 */
@WebServlet("/ServletAboutNewVersion")
public class ServletAboutNewVersion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAboutNewVersion() {
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
		
		String userName = request.getParameter("username");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		 HttpSession session = request.getSession();
	     session.setAttribute("name", "session scoped attribute");
	     
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/SecondPage.jsp");
		dispatcher.forward(request, response);
		
	}

}
