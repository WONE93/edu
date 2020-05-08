package co.yedam.app.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/test1.do", "/test2.do"},// http://localhost/edu/test.do
			loadOnStartup = 1 )// 초기화할 것이 있다면 로드온스타트업!
public class TestServ extends HttpServlet {
	
	String gName = "홍길동"; //전역변수는 특별한 경우만 사용
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("testserv init() 실행");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lName = "김유신";
		System.out.println("testserv service() 실행");
		response.setContentType("text/html; charset=utf-8"); //한글 안깨지게 하기위해
		response.getWriter().append("<hr>테스트 서블릿 실행");
//				.append("pName = " +getInitParameter("pName"))// 초기화파라미터
//				.append("gName = " +gName) //전역변수
//				.append("lName = " +lName); //로컬변수
//		
		gName = request.getParameter("name");
		for(int i=0; i<10; i++) {
			response.getWriter().append( "<br>"+gName+"<br>");
			response.getWriter().flush();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
