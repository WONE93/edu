<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ajaxXml.jsp</title>
<script>
	function findName() {
		//1.xhr
		var xhr = new XMLHttpRequest();
		//2.콜백함수
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200 ){
				var xmlDoc = xhr.responseXML;
				var id =  xmlDoc.getElementsByTagName("id")[0].firstChild.nodeValue
				
				var name = xmlDoc.getElementsByTagName("name")[0].firstChild.nodeValue
				result.innerHTML = id + " : " + name;
			}
		}
		//3.서버연결
		xhr.open("get", "../FindNameXML.do?id=" +id.value);
		//4.전송
		xhr.send();
	}
</script>
</head>
<body>
<form name="frm">
	<input name="id" id="id" onchange="findName()"><span id="result"></span>
</form>
</body>
</html>