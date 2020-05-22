<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ajaxXml.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function findNameJquery() {
		//1. load
/* 		$("#result").load("../FindNameJSON?id="+id.value, function(){
			alert("end");
		}); */
		
		//2.getJson	
	/* 	$.getJSON("../FindNameJSON", {id:id.value}, function(r){
			$("#result").html( r.name ); //응답결과를 파싱까지해서 뿌려준다 
		} ); */
	
		//3. ajax
		$.ajax( {
			url : "../FindNameJSON",
			data : {id:id.value},
			dataType : "json",
			success : function(r){
				$("#result").html( r.name );
			},
			async : false
		});
		
	}
	
	
	function findName() {
		//1.xhr
		var xhr = new XMLHttpRequest();
		//2.콜백함수
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200 ){
				var obj = JSON.parse(xhr.responseText); //string -> 객체
				result.innerHTML = obj.id+ ":" +obj.name;
			}
		}
		//3.서버연결
		xhr.open("get", "../FindNameJSON?id="+id.value);
		//4.전송
		xhr.send();
	}
</script>
</head>
<body>
<form name="frm">
	<input name="id" id="id" onchange="findNameJquery()"><span id="result"></span>
</form>
</body>
</html>