package co.yedam.app.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/SessionTest")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(20);
		out.print("<br>sessionId:" + session.getId());
		out.print("<br>session 생성시간 :" + new Date(session.getCreationTime()));
		out.print("<br>마지막 접근시간:" + new Date(session.getLastAccessedTime()));
		out.print("<br>유지시간:" + session.getMaxInactiveInterval());
		//경과시간: 현재시간 - 겟크리에이션타임. 
		long cur = System.currentTimeMillis(); 
				//=new Date().getTime(); //현재시간
		long dul = (cur - session.getCreationTime())/1000; //초단위로
		out.print("<br> 경과시간: " + dul);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
