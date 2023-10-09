package Controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Bankdao;
import dto.Bankaccount;
@WebServlet("/adminlogin")
public class Adminlogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("adminemai");
		String Password=req.getParameter("adminpassword");
		if(email.equals("admin@gmail.com")&& Password.equals("admin"))
		{
			resp.getWriter().print("<h1>Succsefully login</h1>");
			Bankdao bankdao=new Bankdao();
	List<Bankaccount>list=bankdao.fetch_all_bank_details();
	
	req.getSession().setAttribute("list", list);
	req.getRequestDispatcher("Accounthome.jsp").include(req, resp);

		}
		else {
			resp.getWriter().print("<h1> Provide coreect credentials</h1>");
			req.getRequestDispatcher("Bankadmin.html").include(req, resp);
		}
		
	}

}
