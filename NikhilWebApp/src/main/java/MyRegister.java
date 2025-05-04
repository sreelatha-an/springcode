

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/MyRegister")
public class MyRegister extends HttpServlet {
	


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		
		String uname=request.getParameter("uname");
		String emailId=request.getParameter("email");
		String upassword=request.getParameter("password");
		String ucity=request.getParameter("ucity");
		
		Model model=new Model();
		model.setUname(uname);
		model.setEmail(emailId);
		model.setUpassword(upassword);
		model.setUcity(ucity);
		
		
		int row=model.register();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("name", uname);
		
		if(row==0)
		{
			response.sendRedirect("/NikhilWebApp/failure.jsp");
		}
		else
		{
			response.sendRedirect("/NikhilWebApp/success.jsp");
		}
	}

}
