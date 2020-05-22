<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>event.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){	//load event
		$("ul").on("mouseover", "li",function(){ 
			$(this).css("backgroundcolor", "green");	
		});
		$("#btnAdd").bind("click", function(){
			$("ul").append( $("<li>").html( $("#title").val() ) );
			
		});
	});
	
</script>
</head>
<body>

<input id="title"><button type="button" id="btnAdd">추가</button>

<ul>
	<li>jsp
	<li>java
</ul>

</body>
</html>