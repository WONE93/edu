<%@page import="java.util.ArrayList"%>
<%@page import="co.yedam.app.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>   <!-- 소스보기에서 공백 없애기 -->
<!DOCTYPE html>
<html>
<head>
<title>회원 목록</title>
<style>
	.mailbg{background-color: yellowgreen;}
</style>
</head>
<body>
	<!-- Nevigation bar -->
	<%@include file="/common/menu.jsp"%>
	<h3>회원목록</h3>
	<table border="1">
	<% ArrayList<MemberVO> list = 
	 				(ArrayList<MemberVO>)request.getAttribute("list"); 
		
			for (MemberVO vo : list) {
		%>
		<tr <%if("f".equals(vo.getGender()) ) { %> class="mailbg" <%} %> >
		
			<td><%=vo.getId()%></td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getGender()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>