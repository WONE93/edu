package co.yedam.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MemberInsert
 */
@WebServlet("/MemberInsert.do")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//포스트 방식일때는 밑의 방식으로 해야 한글 안깨짐
		//응답결과 인코딩  
		response.setContentType("text/html; charset=UTF-8");
		//요청정보 인코딩
		request.setCharacterEncoding("utf-8");
		
		
		//1.파라미터 받기
		String id = request.getParameter("id"); // 이런식으로 아이디와 패스워드 받기												
		String pwd = request.getParameter("pwd");
		
		//자기소개, 이름, 종교, 취미
		String name = request.getParameter("name");
//		String hobby = request.getParameter("hobby");
		String religion = request.getParameter("religion");
		String introduction = request.getParameter("introduction");
		String gender = request.getParameter("gender");
	
		String[] hobby = request.getParameterValues("hobby");
		// 값이 체크박스일 경우에만, 선택지가 여러개인 경우에만 파라미터밸류스로 
		String hobbs = "";
		if(hobby != null)
			for(String temp: hobby) {
				hobbs += temp + ",";
			}
//		response.getWriter().append("<br>id = " + id)
//							.append("<br>pwd = " + pwd)
//							.append("<br>name = " + name)
//							.append("<br>취미 = " + hobbs)
//							.append("<br>religion = " + religion)
//							.append("<br>introduction = " + introduction);
		
		//2.서비스 로직 처리(DAO)
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = new MemberVO();
		
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setHobby(hobbs);
		member.setGender(gender);
		member.setReligion(religion);
		member.setIntroduction(introduction);
		
		int r = memberDAO.memberInsert(member);
		
		//3.회원목록 이동   // include, forward, sendRedirect
		String contextPath = getServletContext().getContextPath();
		response.sendRedirect(contextPath + "/MemberList.do");  
//		response.sendRedirect("/edu/MemberList.do");  //절대경로. 이름 바뀔 수 있기 때문에 위의 방식으로 경로지정
		//센드했을때랑 포워드와의 차이 살펴보기
//		request.getRequestDispatcher("/MemberList.do")
//				.forward(request, response);
		
		//3.결과출력   . 회원이동 전엔 결과출력으로 했음 
//		PrintWriter out = response.getWriter();
//		out.print("<br>아디 = " + id); // System.out.
//		out.append("<br>pwd = " + pwd);
//		out.append("<br>취미 = " + hobbs);
//		out.print("<br> 처리된 건수= " + r);
		
		
		
	}
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//응답결과 인코딩 
//		response.setContentType("text/html; charset=UTF-8");
//		//요청정보 인코딩은 안해도 된다
//		
//		//1.파라미터 받기
//		String querystring = request.getQueryString();
//		response.getWriter().append("질의문자열=" + querystring);
//						
//	}
	
	


}
