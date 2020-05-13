<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>empSalList.jsp</title>
</head>
<body>
	<h3>부서별급여평균</h3>
	<table border="1">
		<tr><th>부서번호</th><th>부서이름</th><th>급여</th><th>평균급여</th><th>합계</th></tr>
	<c:forEach items="${salList}" var="vo">
		<tr>
			<td>${vo.department_id}</td>
			<td>${vo.department_name}</td>
			<td align="right">
			<td><fmt:formatNumber value="${vo.salary}"
								  pattern="\ #,###.00" /></td> 
								  <!-- type="currency" 
								  currencySymbol="$"
								  groupingUsed="1" /> -->
			<td>${vo.cnt}</td>
			<td>
			<fmt:parseNumber value="${vo.avgsal}" type="numAvg" />			
			<fmt:parseNumber value="${numAvg}" type="number" /></td>		
			</tr>			
	</c:forEach>
	</table>
</body>
</html> 

