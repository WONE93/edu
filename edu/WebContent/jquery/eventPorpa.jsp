<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>eventPorpa.jsp</title>
<style>

div { padding: 50px; border: 1px solid green; }
</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#grand").bind("click", function (){alert("grand");});
		$("#parent").bind("click", function (){alert("parent");});
		$("#child").bind("click", function (e){
			alert("child");
			e.stopPropagation(); //전파중지
			});
					
	});
</script>
</head>
<body>
<h3>이벤트 전파</h3>
<div id="grand">grand
	<div id="parent">parent
		<div id="child">child
		</div>
	</div>
</div>

</body>
</html>