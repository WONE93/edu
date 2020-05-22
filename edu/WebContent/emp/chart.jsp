<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', '부서');
        data.addColumn('number', '인원수');
        
        //ajax 호출
        var list = getChartDataJquery();
        data.addRows(list);
        
        
/*         data.addRows([
            ['인사부', 5],
            ['개발부', 10],
            ['기획', 5],
          ]); */
        /*         data.addRows([
          ['인사부', 5],
          ['개발부', 10],
          ['기획', 5],
        ]); */

        // Set chart options
        var options = {'title':'부서별 인원수',
                       'width':900,
                       'height':600};

        // Instantiate and draw our chart, passing in some options.
        //var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);
        
        function getChartDataJquery(){
        	var list = [];
        	
        	
        	
        	return list;
        }
        
        
    	function getChartData() {
   			var list = [];
    		//1.xhr
    		var xhr = new XMLHttpRequest();
    		//2.콜백함수
    		xhr.onreadystatechange = function(){
    			if(xhr.readyState == 4 && xhr.status == 200 ){
    				var obj = JSON.parse(xhr.responseText);
    						//[]
    				for(i=0; i<obj.length; i++){
//    					var temp = [];
  //  					temp.add(obj[i].department_id);
    //					temp.add(obj[i].cnt);
    	//				list.add(temp);
    					list.push( [obj[i].department_name, parseFloat(obj[i].salary) ] ); //이렇게 한줄로 표현가능
    				}
    				
    			}
			
    		}
    		//3.서버연결
    		xhr.open("get", "../GetEmpCnt.do", false); // 비동기설정: flase= 동기
    		//4.전송
    		xhr.send();
    		return list;
    	}
    	
      }
    </script>
  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <div id="chart_div"></div>
  </body>
</html>