package co.yedam.app.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.파라미터
		// 로그인 안되어있으면 로그인페이지로
		String id = (String) request.getSession().getAttribute("loginId");
		if (id == null) {
			response.sendRedirect("/edu/member/memberLogin.jsp");
			return;
		}

		// 2. 서비스(DAO 목록조회)
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.getBoardList();

		// 3. 결과출력 OR 결과저장해서 view 포워드
		request.setAttribute("list", list);
		request
		.getRequestDispatcher("/board/boardList.jsp")
		.forward(request, response);
		
		
		// 응답결과 인코딩
//		response.setContentType("text/html; charset=UTF-8");
//
//		PrintWriter out = response.getWriter();
//		request.getRequestDispatcher("/common/menu.jsp").include(request, response);
//
//		out.print("<h3>게시판목록</h3>");
//		out.print("<table border>");
//
//		for (BoardVO bvo : list) {
//			out.print("<tr>");
//			out.print("<td>" + bvo.getName() + "</td>");
//			out.print("<td>" + bvo.getTitle() + "</td>");
//			out.print("<td>" + bvo.getRegdt() + "</td>");
//			out.print("<tr>");
//
//		}
//
//		out.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
