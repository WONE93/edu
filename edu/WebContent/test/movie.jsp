<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>movie.jsp</title>
<script>
	function getBoxOffice(){
		//1.xhr
		var xhr = new XMLHttpRequest();
		//2.콜백함수
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200 ){
			var obj = JSON.parse(xhr.responseText);
			
			for(var i=0; i<obj.boxOfficeResult.dailyBoxOfficeList.length; i++){
				result.innerHTML += obj.boxOfficeResult.dailyBoxOfficeList[i].movieNm + "<br>"
			}
				
				
			}
		}
		//3.서버연결
		xhr.open("get", "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20200517");
		//4.전송
		xhr.send();
	}
</script>
</head>
<body>
<button type="button" onclick="getBoxOffice()">박스오피스조회</button>
<div id="result"></div>

</body>
</html>