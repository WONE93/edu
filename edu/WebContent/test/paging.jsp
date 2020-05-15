<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="my" tagdir ="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>
<script>
   function gopage(p){
      location.href = "paging.jsp?p="+p
   }
</script>
</head>
<body>

<h2>페이징 테스트</h2>
<my:paging st="1" ed="5" p="${param.p}"/>
<my:paging ed="10" p="${param.p}" />
<my:deptSelect></my:deptSelect>



</body>
</html>