package co.yedam.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//2. 서비스 로직
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMember(id);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
	
			//id 조회결과 없으면 id 없다
			if(vo.getId() == null ) { //id 오류
				out.print("id 오류");
			}else if(! vo.getPwd().equals(pwd)) { //pwd 오류
				out.print("pwd 오류");
			}else { //login OK
				
				//세션에 로그인 여부를 저장
				HttpSession session = request.getSession();
				session.setAttribute("loginId", id);
				session.setAttribute("loginMember", vo);
				out.print("로그인 성공");
			}
			//로그인 성공페이지에 메뉴바 보이게
			request.getRequestDispatcher("/common/menu.jsp")
				   .include(request, response); //포워드는 페이지 완전 넘어가는거고, 인클루드는 이페이지에 끼워넣는것
			//조회되면 pwd 검사해서 틀리면 pwd 오류
			//로그인
		
		//3. 결과 저장
		
		//4. 뷰페이지로 포워드
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
