<%@page import="co.yedam.app.board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판 목록</title>
</head>
<body>
	<!-- Nevigation bar -->
	<%@include file="/common/menu.jsp"%>
	<%
		if (loginId != null) {
	%>
	<a href="BoardInsert.do">게시글등록</a>
	<%
		}
	%>

	<h3>게시글목록</h3>
	<table border="1">
		<%
			ArrayList<BoardVO> list = (ArrayList<BoardVO>) request.getAttribute("list");
			for (BoardVO vo : list) {
		%>
		<tr>
			<td><%=vo.getName()%></td>
			<td><%=vo.getId()%></td>
			<td><%=vo.getTitle()%></td>
			<td><%=vo.getRegdt()%></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>