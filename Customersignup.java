package Controler;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import Dao.Dao;
import dto.Customer;


@WebServlet("/customersignup")
public class CustomerSignup extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String custname=req.getParameter("custname");
		String custmobile=req.getParameter("mobile");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		String dob=req.getParameter("dob");
		
		long mobile=Long.parseLong(custmobile);
		
		//long mobile1=Long.parseLong(mobile1);
		/*resp.getWriter().print("<h1>name: "+custname+"<h1>");
		resp.getWriter().print("<h1>mobile: "+mobile+"<h1>");
		resp.getWriter().print("<h1>password: "+password+"<h1>");
		resp.getWriter().print("<h1>email: "+email+"<h1>");
		resp.getWriter().print("<h1>gender: "+gender+"<h1>");
		resp.getWriter().print("<h1>dob: "+dob+"<h1>");*/
		
//		resp.getWriter().print("<h1>name: "+custname+"<h1>"
//				+ "<h1>mobile: "+mobile+"<h1>"
//				+ "<h1>password: "+password+"<h1>"
//				+ "<h1>email: "+email+"<h1>"
//				+ "<h1>gender: "+gender+"<h1>"
//				+ "<h1>dob: "+dob+"<h1>");
		Date date=Date.valueOf(dob);
		
		Period period=Period.between(date.toLocalDate(), LocalDate.now());
		
		int age=period.getYears();
		
		if (age<18)
		{
			resp.getWriter().print("<h1>He is not eligible to create a Bank Account <h1>");
		}else {
			//resp.getWriter().print("<h1>He is not eligible to create a Bank Account <h1>");
		 Dao dao=new Dao();
			
//		Customer customer1= dao.fetch(mobile);
//		
//		Customer customer2=dao.fetch(email);
		 
		 List<Customer>list1=dao.fetch(mobile);
		 List<Customer>list2=dao.fetch(email);
		 
		 if(list1.isEmpty() && list2.isEmpty())
		
		
		 {
			Customer customer =new Customer();
		  customer.setName(custname);
		  customer.setEmail(email);
		  customer.setGender(gender);
		  customer.setPassword(password);
		  customer.setDob(date);
		  customer.setMob(mobile);
		  
		//Dao dao  =new Dao();
		dao.save(customer);
		
//		resp.getWriter().print("<h1>account create succssefully<h1>");
//		  
	
		Customer customer2=dao.fetch(email).get(0);
		long id=customer2.getCustid();
		if(customer2.getGender().equals("male")) {
			resp.getWriter().print("<h1> Hello Sir account create succssefully<h1>");
			resp.getWriter().print("<h1>your customer id is :"+id+" <h1>");
           req.getRequestDispatcher("home.html").include(req, resp);
		}
		else {
			resp.getWriter().print("<h1>hello madam account create succssefully<h1>");
			resp.getWriter().print("<h1>your customer id is :"+id+" <h1>");
	           req.getRequestDispatcher("home.html").include(req, resp);

		}
		
		}
		 else {
				resp.getWriter().print("<h1>account is alreadyexisted<h1>");

			}
		}
		
	}
}
