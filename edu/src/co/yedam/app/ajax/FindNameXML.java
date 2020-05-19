package co.yedam.app.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.member.MemberDAO;
import co.yedam.app.member.MemberVO;

/**
 * Servlet implementation class FindNameXML
 */
@WebServlet("/FindNameXML.do")
public class FindNameXML extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindNameXML() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터 받기
		String id = request.getParameter("id");
				
		//2.서비스 로직 처리
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMember(id);
				
		//3. 결과를 전송
		response.setContentType("text/xml; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<result>");
			out.print("<id>");
			 out.print(vo.getId());
			out.print("</id>");
			out.print("<name>");
			 out.print(vo.getName());
			out.print("</name>");
		out.print("</result>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
