<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>selector.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

$(function(){
	$("#result").hide(); //첨엔 숨겼다가 
	$("#btn").mouseover( function(){
		$("#result").toggle(2000); //onoff기능
		
	});
	
});

/* window.addEventListener("load", init);
function init() {
	var movieDiv = document.getElementById("result");
	movieDiv.style.display = "none";
	
	var btnView = document.getElementById("btn");
	btnView.addEventListener("click", function(){	
		movieDiv.style.display = "";
	});
} */
</script>

</head>
<body>
<button type="button" id="btn">보이기</button>
<div id="result"> 영화 상세 정보 </div>
<input name="userid">
<input name="userpw">
       <table>
         <tbody>
         <tr><th>이름</th><th> 부서</th><th>나이</th></tr>
         <tr><td>1</td><td>4</td><td>7</td></tr>
         <tr><td>2</td><td>5</td><td>8</td></tr>
         <tr><td>3</td><td>6</td><td>9</td></tr>
         </tbody>
         </table>

</body>
</html>