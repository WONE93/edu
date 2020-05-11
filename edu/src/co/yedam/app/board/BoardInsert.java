package co.yedam.app.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/BoardInsert.do" )
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request
		.getRequestDispatcher("/board/boardInsert.jsp")
		.forward(request, response);
		
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 포스트 방식일때는 밑의 방식으로 해야 한글 안깨짐
		// 응답결과 인코딩
		response.setContentType("text/html; charset=UTF-8");
		// 요청정보 인코딩
		request.setCharacterEncoding("utf-8");

		// 1.파라미터 받기
		String title = request.getParameter("title"); // 이런식으로 아이디와 패스워드 받기
		String contents = request.getParameter("contents");
		String id = request.getParameter("id");


		// 2.서비스 로직 처리(DAO)
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = new BoardVO();

		
		board.setTitle(title);
		board.setContents(contents);
		board.setId(id);


		int r = boardDAO.boardInsert(board);

		// 3.결과출력
		PrintWriter out = response.getWriter();
		out.print("<br>아디 = " + id); // System.out.
		out.append("<br>타이틀 = " + title);
		out.append("<br>내용 = " + contents);
		out.print("<br> 처리된 건수= " + r);
	}

}
