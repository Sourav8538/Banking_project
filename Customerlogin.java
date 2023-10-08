package Controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Dao;
import dto.Customer;
@WebServlet("/customerlogin")
public class Customerlogin extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String custid=req.getParameter("custid");
		String pwd=req.getParameter("pwd");
		long id=Long.parseLong(custid);
		Dao dao=new Dao();
		Customer customer=dao.fetchbyCustid(id);
		if(customer==null) {
			resp.getWriter().print("<h1>You have entered a invalid custid<h1>");
			req.getRequestDispatcher("/Customerlogin.html").include(req, resp);

		}
			else {
				if(customer.getPassword().equals(pwd))
				{
					resp.getWriter().print("<h1>Login done Successfully<h1>");
					req.getSession().setAttribute("customer", customer);
					req.getRequestDispatcher("customerhome.html").include(req, resp);
				}
				else {
					resp.getWriter().print("<h1> You  entered invalid pass word<h1>");
					req.getRequestDispatcher("/Customerlogin.html").include(req, resp);
				}
			}
		}
	}


