package step02.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginTest")
public class LoginLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그아웃 처리
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		if(session != null && session.getAttribute("id") != null) {
			// 세션의 정보 삭제
			session.invalidate();
			out.print("로그아웃 완료");
		} else {
			out.print("로그인 상태가 아닙니다.");
		}
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버 응답 시 클라이언트에게 메타 정보 전달
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 클라이언트에서 입력한 id, pw값 받기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// id, pw 중 하나라도 입력 안하면 돌려보내기
		if (id.isEmpty() || pwd.isEmpty()) {
			out.print("아이디 및 비밀번호를 입력해주세요");
			return;
		}
		
		// 세션 객체 생성
		HttpSession session = request.getSession();
		if(session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id); // id라는 이름의 키캆으로 id값 저장
			out.print("로그인 완료.");
		} else {
			out.print("현재 로그인 상태입니다.");
		}
		
		out.close();
	}

}
