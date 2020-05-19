package co.yedam.app.board;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import co.yedam.app.common.FileRenamePolicy;


/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/BoardInsert.do" )
@MultipartConfig(location="d:/upload")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//목록으로 페이지 이동
		request.getRequestDispatcher("/board/boardInsert.jsp").forward(request, response);

		
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 포스트 방식일때는 밑의 방식으로 해야 한글 안깨짐
		// 응답결과 인코딩
		response.setContentType("text/html; charset=UTF-8");
		// 요청정보 인코딩
		request.setCharacterEncoding("utf-8");

		// 1.파라미터 받기
		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String contents = request.getParameter("contents");

		
		// 2.서비스 로직 처리(DAO)
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = new BoardVO();

		
		board.setTitle(title);
		board.setContents(contents);
		board.setId(id);
		
		//첨부파일  처리
				Part part = request.getPart("filename");
				String fileName = getFileName(part);
				String path = "d:/upload";
				if(fileName != null && !fileName.isEmpty()) {
					//중복파일명 처리
					File f = FileRenamePolicy.rename(new File(path, fileName));
					part.write(f.getAbsolutePath()); //업로드폴더에저장
					board.setFilename(f.getName()); //파일명을 vo 담기
				}

		int r = boardDAO.boardInsert(board);

/*		// 3.결과출력
		PrintWriter out = response.getWriter();
		out.print("<br>아디 = " + id); // System.out.
		out.append("<br>타이틀 = " + title);
		out.append("<br>내용 = " + contents);
		out.print("<br> 처리된 건수= " + r);  */
		
		response.sendRedirect(request.getContextPath()+ "/BoardList.do");
	}
	
	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}


}
