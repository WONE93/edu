<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> 게시판 등록 </title>
</head>
<body>
	<!-- Nevigation bar -->
	<%@include file="/common/menu.jsp"%>
	
	<h3>게시판</h3>
	<form action="/edu/BoardInsert.do" 
		  method="post" 
		  enctype="multipart/form-data">
	작성자 : <input type="text" name="id"  value= "${loginId}"><br/>								
	제목 : <input type ="text" name="title" id="title"/><br/>
	내용: <textarea cols="30" name="contents" id="contents"></textarea><br/>
	첨부파일: <input type="file" name="filename"><br>
		<button>등록</button>
</form>
</body>
</html>