<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
	function idDupCheck(){
		//1. xhr 객체 생성
		  var xhttp = new XMLHttpRequest();
		//2. 콜백함수지정
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 ) {	//응답완료
		    	if( this.status == 200){	//정상실행
		    		console.log("ajax 요청완료");
		     		 document.getElementById("result").innerHTML =
		     									 this.responseText;
		    	}else{
		    		document.getElementById("result").innerHTML = 
		    											this.status + this.statusText
		    	}	    		
		    }else {
		    	//로딩중
		    	 document.getElementById("result").innerHTML = "로딩중";
		    }
		  };
		  //3. 서버연결
		  var param = "id=" +document.frm.id.value;		  
		  xhttp.open("POST", "../idDupCheck.do?", true); //.디폴트가 트루 대부분이 비동기임 동기식의 경우 꼭 순착적 결과까지 확인하고 넘어감  (비동기여부체크)f & t
		  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		  //4.서버 전송
		  xhttp.send(param); //get방식이면 위에 do 옆에 +param . post방식이면 ()안에 넣기
		console.log("ajax 요청시작");
	}
	
</script>
<body>
</head>
  <!-- navigation bar -->
   <%@include file="/common/menu.jsp" %>
   <!-- contents -->
   <h3>회원 정보</h3>
   <form action="../MemberInsert.do" method="post" name="frm">
      <p>ID : <input type="text" name="id" id="id" onchange="idDupCheck()"/>
            <span id="result"></span>
      </p>
      <p>비밀번호 : <input type="password" name="pwd" id="pwd"/></p>
      <p>이름 : <input type="text" name="name" id="name"/></p>
      <div>
         취미 :
         <input type="checkbox" value ="h01" name="hobby"/> 등산
         <input type="checkbox" value ="h02" name="hobby"/> 운동
         <input type="checkbox" value ="h03" name="hobby"/> 독서
         <input type="checkbox" value ="h04" name="hobby"/> 여행
      </div>
      <div>
         성별 :
         <input type="radio" value ="m" name="gender"/> 남자
         <input type="radio" value ="f" name="gender"/> 여자
      </div>
      <div>
         종교 :
         <select name="religion" id="religion">
            <option value ="r01">기독교
            <option value ="r02">불교
            <option value ="r03">천주교
            <option value ="r04">무교
         </select>
      </div>
      <div>
      자기소개<br>
      <textarea cols="30" rows="10" name="introduce" id="introduce"></textarea>
      </div>
      <button type="submit">전송</button>
      <button type="reset">지우기</button>
      
   </form>
</body>
</html>