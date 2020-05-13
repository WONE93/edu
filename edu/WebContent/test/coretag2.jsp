<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>coretag2.jsp</title>
</head>
<body>
<%--
	String scoreStr = request.getParameter("score");
	int score = Integer.parseInt(scoreStr);s
	if( score > 60 )
		out.print("<font style='color:blue'>pass</font>");
	else {
		out.print("<font style='color:red'>fail</font>");
	}
--%>
<%-- <c:if test="${param.score >= 60}">
	<font style='color:blue'>합격</font>
</c:if>
<c:if test="${param.score < 60}">
	<font style='color:red'>불합격</font>
</c:if> --%>

<c:choose>
	<c:when test="${param.score >= 90}">
	<font style='color:blue'>A등급</font>
	</c:when>
	<c:when test="${param.score >= 80}"> 
	<font style='color:blue'>B등급</font>
	</c:when>
	<c:when test="${param.score >= 70}"> 
	<font style='color:blue'>C등급</font>
	</c:when>
	<c:when test="${param.score <= 60}"> 
	<font style='color:blue'>D등급</font>
	</c:when>
	<c:otherwise>
		성적입력
	</c:otherwise>	
</c:choose>

</body>
</html>