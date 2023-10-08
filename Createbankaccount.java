package Controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Bankdao;
import Dao.Dao;
import dto.Bankaccount;
import dto.Customer;
@WebServlet("/createbankaccount")
public class Create_bank_account extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String banktype=req.getParameter("banktype");
		
		Customer customer=(Customer) req.getSession().getAttribute("customer");
		
		List<Bankaccount>list=customer.getList();//will give the list of bank accouunts which have been creates for current user
	
		boolean flag=true;
		
		for (Bankaccount bankaccount : list) {
			if(bankaccount.getAccount_type().equals(banktype));
			{
				resp.getWriter().print("<h1>Already account is existed<h1>");
				flag=false;
			}
		}
		
		if(flag) {
		Bankaccount bankaccount=new Bankaccount();
		//bankaccount.setaccount_no(0);   :----it will automatically generated
	//bankaccount.setAmount(0);
		//bankaccount.setStatus(false);
		bankaccount.setAccount_type(banktype);
		
		
		if(bankaccount.getAccount_type().equals("savings"))
		
			bankaccount.setAcc_limit(10000.00);
		
		else 
			bankaccount.setAcc_limit(15000.00);
		
		bankaccount.setCustomer(customer);
		
		
	 Bankdao  bankdao=new Bankdao();
	 bankdao.save(bankaccount);
	 
	 
	 List<Bankaccount> list2=list;
	 list2.add(bankaccount);
	 customer.setList(list2);
	 
	Dao dao=new Dao();
	dao.update(customer);
	resp.getWriter().print("<h1>Your Request is created... under process for manager aproval<h1>");
	req.getRequestDispatcher("Bankadmin.html").include(req, resp);
		} 
	}

}
