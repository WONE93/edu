package co.yedam.app.emp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.emp.EmpDAO;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class getEmpCnt
 */
@WebServlet("/GetEmpCnt.do")
public class GetEmpCnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> list = EmpDAO.getInstance().selectDeptSal();
		// java 객체를 => json string으로 바꿔야함 [ {"department_id:" "ddd", cnt:5} ] 이렇게 // 차트는 조회용도라서 get 만 있으면 됨
//		String result = "[";
//		for(int i=0; i<list.size(); i++) {
//			result += "{";
//			result += "\"department_id\":";
//			result += "\""+list.get(i).get("department_name")+"\",";			
//			result += "\"cnt\":";
//			result += list.get(i).get("cnt");
//			result += "}";
//			if(i < list.size()-1) {
//				result += ",";
//			
//			}
//		}
//		result += "]";
		
		String result = JSONArray.fromObject(list).toString();
		response.getWriter().print(result);
	}



}
