<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page trimDirectiveWhitespaces="true" %> <!-- 자바문 소스보기에서 공백없애기 -->
<!DOCTYPE html>
<html>
<head>
<title>스크립트 요소 연습</title>
</head>
<body>
<h3> 5행 7열</h3>
<table border="1">
<!-- 스크립트요소연습 -->
<%! //메서드 선언
	public int mul(int m, int n) {
	return m*n;
}
%>

<% for(int i=1; i<5; i++){ %>
	<tr>
		<%for(int j=1; j<7; j++) { %>
		<td> <%=mul(i,j) %></td>
		<%} %>
	</tr>
		<%} %>
</table>

</body>
</html>