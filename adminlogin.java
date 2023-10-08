package Controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/adminlogin")
public class Adminlogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("adminemai");
		String Password=req.getParameter("adminpassword");
		if(email.equals("admin@gmail.com")&& Password.equals("admin"))
		{
			resp.getWriter().print("<h1>Succsefully login</h1>");
		}
		else {
			resp.getWriter().print("<h1> Provide coreect credentials</h1>");

		}
		
	}

}
