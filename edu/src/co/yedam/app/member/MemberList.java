package co.yedam.app.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberList
 */
@WebServlet("/MemberList.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터
		
		//2. 서비스(DAO 목록조회)
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.getMemberList();
		
		//3. 결과출력 OR 결과저장해서 view 포워드
		//응답결과 인코딩  
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("/common/menu.jsp").include(request, response);
		out.print("<h3>회원목록</h3>");
		out.print("<table border>");
		for(MemberVO vo : list) {
			out.print("<tr>");
			out.print("<td>" +vo.getId() +"</td>");
			out.print("<td>" +vo.getName() +"</td>");
			out.print("<td>" +vo.getIntroduction() +"</td>");
			out.print("<tr>" );
			
		}

		out.print("</table>");
	}




}
