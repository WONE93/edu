<%@page import="co.yedam.app.emp.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>사원 목록</title>
<style>
	.mailbg{background-color: red;}
</style>
</head>
<body>
	<!-- Nevigation bar -->
	<%@include file="/common/menu.jsp"%>
	
	<a href="EmpInsert.do">사원등록</a>

	
	<h3>사원 목록</h3>
	<table border="1">
	
	<% List<EmpVO> list = 
	 				(List<EmpVO>)request.getAttribute("list"); 
		
			for (EmpVO vo : list) {
		%>
		<tr>
		
			<td><%=vo.getEmployee_id()%></td>
			<td><%=vo.getFirst_name()%></td>
			<td><%=vo.getLast_name()%></td>
			<td><%=vo.getSalary()%></td>
			<td><%=vo.getCommission_pct()%></td>
			<td><%=vo.getHire_date()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>