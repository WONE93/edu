<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>coreFor.jsp</title>
</head>
<body>
<%
	int sum = 0;
	for(int i=1; i<=10; i++) {
		out.print(i+"<br>");
		sum = sum + i;
	}
	out.print("합계="+sum);
%>

<!--  jstl -->
<hr>
<c:set var="sum" value="0" />
<c:forEach begin="1" end="10" step="1" var="i" >
	${i}<br>
	<c:set var="sum" value="${sum+i}" />
</c:forEach>
합계=${sum}


<hr>
<%
	String str = "jsp,java,spring";
	StringTokenizer st = new StringTokenizer(str,","); 
	out.print("<select>");
	while(st.hasMoreElements()) {
		out.print( "<option>" +st.nextElement() + "<br>");
	}
	out.print("</select>");
%>

<hr>
<select>
<c:forTokens items="jsp,java,spring" delims="," var="op">
	<option>${op}</option>
</c:forTokens>
</select>

<%-- request.getRequestDispatcher("").include(arg0, arg1)-%>
<jsp:include page="" /> --%>
<c:import url="/common/menu.jsp"></c:import>

<c:url var="boardList" value="../BoardList.do">
	<c:param name="title">제목</c:param>
	<c:param name="id">작성자</c:param>
</c:url>
<a href="${boardList}">게시판목록검색</a>
<a href="../BoardList.do?title=제목&id=작성자">게시판목록검색</a>
</body>
</html>