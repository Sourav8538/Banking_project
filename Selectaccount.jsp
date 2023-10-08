
<%@page import="dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>welcome to the account creation page</h1>
	<% Customer customer=(Customer)request.getSession().getAttribute("customer"); %>
	<h1>hello: <%= customer.getName() %></h1>
	
	<h1>Select Account Type</h1>
	<form action="createbankaccount" method="post">
	<input type="radio" name="banktype" value="savings" required="required">Savings
	<input type="radio" name="banktype" value="current" >Current<br><br>
	<button>Submit</button> <button type="reset">Cancel</button>
	</form>


</body>
</html>
