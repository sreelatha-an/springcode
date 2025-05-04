

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class UseServletGet
 */
@WebServlet("/UserServletGet")
public class UserServletGet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		 RequestDispatcher reqDisp  = request.getRequestDispatcher("/SecondServlet");
		if(userName.equals("nikhil")) {
			System.out.println("Great! Nikhil has successfully logged in, forwarding");
			reqDisp.forward(request, response);
		}
		else {
			System.out.println("other person logged in, including");
			reqDisp.include(request, response);
		}
	}

}
