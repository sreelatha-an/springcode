

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
//		PrintWriter pw = response.getWriter();
//		pw.write("<html><head><title>Nikhil WebApp Project</title></head>\r\n"
//				+ "<body bgcolor='pink'><h1><marquee>Welcome to Nikhil WebApp Project</marquee></h1>\r\n"
//				+ "Hello "+ userName +"</body></html>");
//		pw.close();
		response.sendRedirect("/NikhilWebApp/LoggedIn.jsp");
	}

}
