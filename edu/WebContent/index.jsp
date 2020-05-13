<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>혜원index</title>
</head>
<body>
	<!-- navigation bar -->
	<%@include file="/common/menu.jsp"%>
	
	<%-- <jsp:include page="/common/menu.jsp"/>  //common파일이 캐쉬파일에 생성된다.  --%>


	<%-- <%request.getRequestDispatcher("/common/menu.jsp").include(request, response); %> --%>
	<%
		application.getRealPath("/");
	%>
	<!-- contents -->
	<h1>혜워닝 홈페이지</h1>
	방문을 환영합니다
	<p>현재 시간은 : ${today}</p>
	<%
		out.print(getServletContext().getRealPath("/"));
	%>
	<br>
	<%
		//request.getRequestDispatcher("BoardList.do").forward(request, response);
	%>
	<%-- <jsp:forward page="MemberList.do"/> --%>



</body>
</html>