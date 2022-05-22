package step04.query.string;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/queryTestEng")
public class QueryServletEng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<h1>GET방식으로 요청되었음</h1>");
		
		String id = request.getParameter("id");
		String password = request.getParameter("pwd");
		String name = request.getParameter("name");

		out.print("ID: "+id+"<br/>");
		out.print("비밀번호: "+password+"<br/>");
		out.print("이름: "+name+"<br/>");
		
		String[] hobbies = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String introduction = request.getParameter("introduction");
		
		for (String hobby : hobbies) {
			out.print("취미: "+hobby+"<br/>");
		}

		out.print("성별: "+gender+"<br/>");
		out.print("국적: "+country+"<br/>");
		out.print("소개: "+introduction+"<br/>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버가 클라이언트로부터 받을 때 참고할 인코딩타입
		// 클라이언트가 서버에게 전달할 정보
		// window - preference - enc검색
		request.setCharacterEncoding("UTF-8");
		// 서버가 클라이언트에게 참고로 안내할 문서 타입과 encoding을 명시
		// 서버가 클라이언트에게 전달할 정보
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<h1>POST방식으로 요청되었음</h1>");
		
		String id = request.getParameter("id");
		String password = request.getParameter("pwd");
		String name = request.getParameter("name");

		out.print("ID: "+id+"<br/>");
		out.print("비밀번호: "+password+"<br/>");
		out.print("이름: "+name+"<br/>");
		
	}

}
